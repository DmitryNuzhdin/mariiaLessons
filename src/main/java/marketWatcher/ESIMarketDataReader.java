package marketWatcher;

import marketWatcher.dto.ESIMarketOrderDTO;

import java.util.Map;

public interface ESIMarketDataReader {
    Map<Long, ESIMarketOrderDTO> readOrders(long typeId);
    }
