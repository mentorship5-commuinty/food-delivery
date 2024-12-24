package food_delivery.enums;

public enum OrderStatus {

    Pending(1L),
    Confirmed(2L),
    InTransit(3L),
    Completed(4L),
    Canceled(5L);

    private final long code;
    OrderStatus(long code) {
        this.code = code;
    }
}
