package marketWatcher;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import java.util.stream.IntStream;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import marketWatcher.dto.ESIMarketOrderDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ESIMarketDataReaderImpl implements ESIMarketDataReader {
    private static final String ESI_API_BASE_URL = "https://esi.evetech.net";
    private static final int ESI_API_REGION = 10000002;
    private static final String ESI_API_ORDER_TYPE = "all";
    private static final String ESI_API_DATASOURCE = "tranquility";
    private static final int ESI_API_PAGE = 1;
    private static final String PAGE_PROPERTY_NAME = "X-Pages";
    private static final String EXPIRES_PROPERTY_NAME = "Expires";

    private ClientHttpConnector connector() {
        return new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection()));
    }

    private final WebClient webClient;

    public ESIMarketDataReaderImpl () {
        this.webClient = WebClient.builder()
                .clientConnector(connector())
                .baseUrl(ESI_API_BASE_URL)
                .build();
    }

    // collect headers, check how to do it
    // add page processing
    //

    @Override
    public Map<Long,ESIMarketOrderDTO> readOrders(long typeId) {
        Map<Long,ESIMarketOrderDTO> mapOfDTO = new HashMap<>();
        ResponseEntity<List<ESIMarketOrderDTO>> serverAnswer = makeReadingRequest(typeId,ESI_API_PAGE);
        serverAnswer.getBody().forEach(entity -> mapOfDTO.put(entity.orderId, entity));
        int pages = Integer.parseInt(serverAnswer.getHeaders().getFirst(PAGE_PROPERTY_NAME));
        if (pages > ESI_API_PAGE) {
            IntStream.rangeClosed(ESI_API_PAGE + 1, pages)
                    .boxed()
                    .map( n -> makeReadingRequest(typeId,n).getBody())
                    .forEach( list -> list.forEach(dto -> mapOfDTO.put(dto.orderId, dto)));
        }
        return mapOfDTO;
    }


    private ResponseEntity<List<ESIMarketOrderDTO>> makeReadingRequest(long typeId, int pageNum ) {
        ResponseEntity<List<ESIMarketOrderDTO>> resp =  webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/latest/markets/{region}/orders")
                        .queryParam("datasource", "{dataSource}")
                        .queryParam("order_type", "{orderType}")
                        .queryParam("page", "{page}")
                        .queryParam("type_id", "{typeId}")
                        .build(ESI_API_REGION, ESI_API_DATASOURCE, ESI_API_ORDER_TYPE, pageNum, typeId))
                .retrieve()
                .toEntityList(ESIMarketOrderDTO.class)
                .block();
        return resp;
    }


    public Map<Long,ESIMarketOrderDTO> readOrdersFirstPage(long typeId) {
          return webClient.get()
                  .uri(uriBuilder -> uriBuilder
                         .path("/latest/markets/{region}/orders")
                         .queryParam("datasource", "{dataSource}")
                          .queryParam("order_type", "{orderType}")
                          .queryParam("page", "{page}")
                          .queryParam("type_id", "{typeId}")
                          .build(ESI_API_REGION, ESI_API_DATASOURCE, ESI_API_ORDER_TYPE, ESI_API_PAGE, typeId))
                  .retrieve()
                  .bodyToFlux(ESIMarketOrderDTO.class)
                  .collectMap(ESIMarketOrderDTO::getOrderId,order -> order)
                  .block();
    }



}



