package marketWatcher.dto;

import marketWatcher.MarketVolumesEntity;
import reactor.util.function.Tuple2;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MarketVolumesDTO implements Serializable {
    long typeId;
    LocalDateTime timestamp;
    Map<Tuple2<Double,OrderType>, Long> volumes;

    public MarketVolumesDTO(long typeId, LocalDateTime timestamp, Map<Tuple2<Double,OrderType>, Long> volumes) {
        this.typeId = typeId;
        this.timestamp = timestamp;
        this.volumes = volumes;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<Tuple2<Double,OrderType>, Long> getVolumes() {
        return volumes;
    }

    public void setVolumes(Map<Tuple2<Double,OrderType>, Long> volumes) {
        this.volumes = volumes;
    }

    @Override
    public String toString() {
        return "MarketVolumesDTO{" +
                "typeId=" + typeId +
                ", timestamp=" + timestamp +
                ", volumes=" + volumes +
                '}';
    }

    public List<MarketVolumesEntity> toMarketVolumesEntityList() {
        return this.volumes.entrySet()
                .stream()
                .map( e -> new MarketVolumesEntity(this.typeId, e.getValue(),
                        e.getKey().getT1(), e.getKey().getT2(), this.timestamp ))
                .collect(Collectors.toList());

    }
}
