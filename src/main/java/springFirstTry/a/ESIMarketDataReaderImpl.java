package springFirstTry.a;

import org.junit.gen5.api.Test;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import springFirstTry.a.dto.ESIMarketOrderDTO;

import java.util.List;

public class ESIMarketDataReaderImpl implements ESIMarketDataReader {
    private static final String ESI_API_BASE_URL = "https://esi.evetech.net";
    private static final int ESI_API_REGION = 10000002;
    private static final String ESI_API_ORDER_TYPE = "all";
    private static final String ESI_API_DATASOURCE = "tranquility";
    private static final int ESI_API_PAGE = 1;

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

    @Override
    public List<ESIMarketOrderDTO> readOrders(long typeId) {
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
                .collectList()
                .block();
    }
}
