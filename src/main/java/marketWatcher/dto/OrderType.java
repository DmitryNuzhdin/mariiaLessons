package marketWatcher.dto;

public enum OrderType {
    Buy(true), Sell(false);

    public final boolean label;

    OrderType(boolean label) {
        this.label = label;
    }
}
