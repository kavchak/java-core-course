package javaCourse.homework.lesson8;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int orderId;
    private OrderStatus status;
    private final LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Order(int orderId) {
        this.orderId = orderId;
        this.status = OrderStatus.NEW;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    public Order(int orderId, OrderStatus status, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.orderId = orderId;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void updateStatus(OrderStatus newStatus) {
        if (isValidNextStatus(newStatus)) {
            this.status = newStatus;
            this.updatedDate = LocalDateTime.now();
            System.out.println("Order status updated to: " + newStatus);
        } else {
            throw new InvalidStatusException("It is not possible to change the order status from " + this.status + " to " + newStatus);
        }
    }

    private boolean isValidNextStatus(OrderStatus newStatus) {
        switch (this.status) {
            case NEW:
                return newStatus == OrderStatus.IN_PROGRESS;
            case IN_PROGRESS:
                return newStatus == OrderStatus.FINISHED || newStatus == OrderStatus.FAILED;
            case FINISHED:
            case FAILED:
                return false;
            default:
                throw new IllegalArgumentException("Unknown order status: " + this.status);
        }
    }

    @Override
    public String toString() {
        return orderId + ";" + status + ";" + createdDate + ";" + updatedDate + "\n";
    }
}
