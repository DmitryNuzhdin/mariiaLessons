package marketWatcher;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

//@Component
public class MarketWatcherService {
    ESIMarketDataReader esiMarketDataReader;
    OrderAggregator orderAggregator;
    MarketVolumesRepository marketVolumesRepository;

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    public MarketWatcherService(OrderAggregator orderAggregator, ESIMarketDataReader esiMarketDataReader, MarketVolumesRepository marketVolumesRepository) {
        this.orderAggregator = orderAggregator;
        this.esiMarketDataReader = esiMarketDataReader;
        this.marketVolumesRepository = marketVolumesRepository;
    }


    void watchTypeId(long typeId){

    }

}
