package springFirstTry.a;

import springFirstTry.a.dto.ESIMarketOrderDTO;

import java.util.List;

public interface ESIMarketDataReader {
    List<ESIMarketOrderDTO> readOrders(long typeId);
}
