package marketWatcher;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;
import marketWatcher.dto.ESIMarketOrderDTO;
import marketWatcher.dto.MarketVolumesDTO;
import marketWatcher.dto.OrderType;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class OrderAggregatorImpl implements OrderAggregator {

    Map<Long, Map<Long, ESIMarketOrderDTO>> lastOrders = new HashMap<>();
    //Map<Long, >
    Double lastMaxBuyLimitOrderPrice;
    Double lastMinSellLimitOrderPrice;

    // find canceled orders and delete them
    @Override
    public MarketVolumesDTO calculateMarketVolumes(Map<Long, ESIMarketOrderDTO> newOrders, long typeId) {
        double maxBuyLimitOrderPrice = Double.MAX_VALUE;
        double minSellLimitOrderPrice = Double.MIN_VALUE;
        Map<Long, ESIMarketOrderDTO> lastOrdersByType = lastOrders.get(typeId);
        Map<Tuple2<Double,OrderType>, Long> allVolumes = new HashMap<>();
        Double minPrice = lastOrdersByType.entrySet()
                .stream()
                .filter(entry -> newOrders.containsKey(entry.getKey()))
                .filter(entry -> !entry.getValue().isBuyOrder)
                .mapToDouble(entry -> entry.getValue().price)
                .min()
                .orElse(Double.MAX_VALUE);
        /*lastOrdersByType.entrySet()
                .stream()
                .filter(entry -> entry.getValue().price < minPrice)
                .filter(entry -> !newOrders.containsKey(entry.getKey()))
                .forEach(entry -> {
                    if (entry.getValue().isBuyOrder)
                        }

                );*/
        newOrders.entrySet()
                .stream()
                .filter(entry -> lastOrdersByType.containsKey(entry.getKey()))
                .forEach(entry -> {
                    OrderType enumOrderType =
                            (entry.getValue().isBuyOrder) ? OrderType.Buy : OrderType.Sell;
                    Long orderVolumes =
                            lastOrdersByType.get(entry.getKey()).volumeRemain - entry.getValue().volumeRemain;
                    allVolumes.merge(Tuples.of(entry.getValue().price, enumOrderType), orderVolumes, Long::sum);
                });
        //allVolumes.replaceAll();
        lastOrders.put(typeId,newOrders);
        return new MarketVolumesDTO(typeId,LocalDateTime.now(),allVolumes);
    }


    public void initOrderMap (Map<Long, ESIMarketOrderDTO> orders, long typeId) { lastOrders.put(typeId,orders);
    }

}
