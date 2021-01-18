package springExample;

import javax.persistence.*;

@Entity
public class ExampleEntity {
    @Id
    @GeneratedValue
    long orderId;
    double price;

    public ExampleEntity() {
    }

    public ExampleEntity(long orderId, double price) {
        this.orderId = orderId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ExampleEntity{" +
                "orderId=" + orderId +
                ", price=" + price +
                '}';
    }

    public long getOrderId() {
        return orderId;
    }

    public double getPrice() {
        return price;
    }
}
