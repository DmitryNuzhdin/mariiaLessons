package springFirstTry;

import javax.persistence.*;

@Entity
@Table(name = "orders_table")
public class RequestEntity {
    @Id
    @Column(name = "order_id")
    long orderId;

    @Column(name = "price")
    double price;

    @Column(name = "is_buy_order")
    boolean isBuyOrder;

    @Column(name = "duration")
    int duration;

    @Column(name = "location_id")
    int locationId;

    @Column(name = "min_volume")
    int minVolume;

    @Column(name = "range")
    String range;

    @Column(name = "system_id")
    long systemId;

    @Column(name = "type_id")
    int typeId;

    @Column(name = "volume_total")
    int volumeTotal;

    @Column(name = "volume_remain")
    int volumeRemain;

    RequestEntity () {
    }


    public long getOrderId() {
        return orderId;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBuyOrder() {
        return isBuyOrder;
    }

    public int getDuration() {
        return duration;
    }

    public int getLocationId() {
        return locationId;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public String getRange() {
        return range;
    }

    public long getSystemId() {
        return systemId;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getVolumeTotal() {
        return volumeTotal;
    }

    public int getVolumeRemain() {
        return volumeRemain;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBuyOrder(boolean buyOrder) {
        isBuyOrder = buyOrder;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void setSystemId(long systemId) {
        this.systemId = systemId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setVolumeTotal(int volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    public void setVolumeRemain(int volumeRemain) {
        this.volumeRemain = volumeRemain;
    }

    @Override
    public String toString() {
        return "RequestEntity{" +
                "orderId=" + orderId +
                ", price=" + price +
                ", isBuyOrder=" + isBuyOrder +
                ", duration=" + duration +
                ", locationId=" + locationId +
                ", minVolume=" + minVolume +
                ", range='" + range + '\'' +
                ", systemId=" + systemId +
                ", typeId=" + typeId +
                ", volumeRemain=" + volumeRemain +
                ", volumeTotal=" + volumeTotal +
                '}';
    }



    public RequestEntity(long orderId, double price, boolean isBuyOrder, int duration, int locationId, int minVolume,
                         String range, long systemId, int typeId, int volumeRemain, int volumeTotal) {
        this.orderId = orderId;
        this.price = price;
        this.isBuyOrder = isBuyOrder;
        this.duration = duration;
        this.locationId = locationId;
        this.minVolume = minVolume;
        this.range = range;
        this.systemId = systemId;
        this.typeId = typeId;
        this.volumeRemain = volumeRemain;
        this.volumeTotal = volumeTotal;
    }



}
