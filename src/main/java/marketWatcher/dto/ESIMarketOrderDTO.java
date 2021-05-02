package marketWatcher.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ESIMarketOrderDTO {
    public Long orderId;
    public double price;
    public boolean isBuyOrder;
    int duration;
    long locationId;
    int minVolume;
    String range;
    long systemId;
    public int typeId;
    public int volumeTotal;
    public Long volumeRemain;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "UTC")
    LocalDateTime issued;

    @JsonCreator
    public ESIMarketOrderDTO(
            @JsonProperty("order_id") Long  orderId,
            @JsonProperty("price") double price,
            @JsonProperty("is_buy_order") boolean isBuyOrder,
            @JsonProperty("duration") int duration,
            @JsonProperty("location_id") long locationId,
            @JsonProperty("min_volume") int minVolume,
            @JsonProperty("range") String range,
            @JsonProperty("system_id") long systemId,
            @JsonProperty("type_id") int typeId,
            @JsonProperty("volume_total") int volumeTotal,
            @JsonProperty("volume_remain") Long volumeRemain,
            @JsonProperty("issued") LocalDateTime issued) {
        this.orderId = orderId;
        this.price = price;
        this.isBuyOrder = isBuyOrder;
        this.duration = duration;
        this.locationId = locationId;
        this.minVolume = minVolume;
        this.range = range;
        this.systemId = systemId;
        this.typeId = typeId;
        this.volumeTotal = volumeTotal;
        this.volumeRemain = volumeRemain;
        this.issued = issued;
    }

    @JsonProperty("order_id")
    public Long getOrderId() {
        return orderId;
    }

    @JsonProperty("order_id")
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("price")
    public double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("is_buy_order")
    public boolean isBuyOrder() {
        return isBuyOrder;
    }

    @JsonProperty("is_buy_order")
    public void setBuyOrder(boolean buyOrder) {
        isBuyOrder = buyOrder;
    }

    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @JsonProperty("location_id")
    public long getLocationId() {
        return locationId;
    }

    @JsonProperty("location_id")
    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    @JsonProperty("min_volume")
    public int getMinVolume() {
        return minVolume;
    }

    @JsonProperty("min_volume")
    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    @JsonProperty("range")
    public String getRange() {
        return range;
    }

    @JsonProperty("range")
    public void setRange(String range) {
        this.range = range;
    }

    @JsonProperty("system_id")
    public long getSystemId() {
        return systemId;
    }

    @JsonProperty("system_id")
    public void setSystemId(long systemId) {
        this.systemId = systemId;
    }

    @JsonProperty("type_id")
    public int getTypeId() {
        return typeId;
    }

    @JsonProperty("type_id")
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @JsonProperty("volume_total")
    public int getVolumeTotal() {
        return volumeTotal;
    }

    @JsonProperty("volume_total")
    public void setVolumeTotal(int volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    @JsonProperty("volume_remain")
    public Long getVolumeRemain() {
        return volumeRemain;
    }

    @JsonProperty("volume_remain")
    public void setVolumeRemain(Long volumeRemain) {
        this.volumeRemain = volumeRemain;
    }

    @JsonProperty("issued")
    public LocalDateTime getIssued() {
        return issued;
    }

    @JsonProperty("issued")
    public void setIssued(LocalDateTime issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return "ESIMarketOrderDTO{" +
                "orderId=" + orderId +
                ", price=" + price +
                ", isBuyOrder=" + isBuyOrder +
                ", duration=" + duration +
                ", locationId=" + locationId +
                ", minVolume=" + minVolume +
                ", range='" + range + '\'' +
                ", systemId=" + systemId +
                ", typeId=" + typeId +
                ", volumeTotal=" + volumeTotal +
                ", volumeRemain=" + volumeRemain +
                ", issued=" + issued +
                '}';
    }
}
