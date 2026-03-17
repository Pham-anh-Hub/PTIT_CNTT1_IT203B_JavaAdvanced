package PTIT_CNTT1_IT203B_Session07.BTTH.model;

public class Order {
    private String orderId;
    private String customerName;
    private String email;
    private double totalMoneys;

    public Order() {
    }

    public Order(String orderId, String customerName, String email, double totalMoneys) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.email = email;
        this.totalMoneys = totalMoneys;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalMoneys() {
        return totalMoneys;
    }

    public void setTotalMoneys(double totalMoneys) {
        this.totalMoneys = totalMoneys;
    }
}
