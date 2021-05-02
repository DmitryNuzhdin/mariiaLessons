package marketWatcher;

import marketWatcher.dto.ESIMarketOrderDTO;
import marketWatcher.dto.MarketVolumesDTO;

import java.util.Map;

public interface OrderAggregator {
    MarketVolumesDTO calculateMarketVolumes(Map<Long, ESIMarketOrderDTO> newOrders, long typeId);

}
