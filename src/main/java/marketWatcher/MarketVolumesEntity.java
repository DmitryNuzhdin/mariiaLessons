package marketWatcher;

import marketWatcher.dto.OrderType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MarketVolumesEntity {
    @Id
    @Column(name = "global_id")
    @GeneratedValue
    long globalId;

    @Column(name = "order_type_id")
    long typeId;

    @Column(name = "volumes")
    long volumes;

    @Column(name = "price")
    double price;

    @Column(name = "order_type")
    @Enumerated(EnumType.STRING)
    OrderType orderType;

    @Column(name = "created_time")
    LocalDateTime timestamp;



    public MarketVolumesEntity(long typeId, long volumes, double price, OrderType orderType, LocalDateTime timestamp) {
        this.typeId = typeId;
        this.volumes = volumes;
        this.orderType = orderType;
        this.timestamp = timestamp;
        this.price = price;
    }

    public long getGlobalId() {
        return globalId;
    }

    public long getTypeId() {
        return typeId;
    }

    public long getVolumes() {
        return volumes;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getPrice() {
        return price;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public void setVolumes(long volumes) {
        this.volumes = volumes;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
