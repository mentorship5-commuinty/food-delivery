package food_delivery.enums;

public enum OrderStatusEnum {
    Pending(1L),
    Confirmed(2L),
    InTransit(3L),
    Completed(4L),
    Canceled(5L);

    private final Long code;

    OrderStatusEnum(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }
}
