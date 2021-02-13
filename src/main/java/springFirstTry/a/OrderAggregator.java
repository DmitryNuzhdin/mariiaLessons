package springFirstTry.a;

import springFirstTry.a.dto.ESIMarketOrderDTO;
import springFirstTry.a.dto.MarketVolumesDTO;

import java.util.List;

public interface OrderAggregator {
    MarketVolumesDTO calculateMarketVolumes(List<ESIMarketOrderDTO> newOrders, long typeId);
}
