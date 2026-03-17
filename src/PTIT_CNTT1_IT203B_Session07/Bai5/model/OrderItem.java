package PTIT_CNTT1_IT203B_Session07.Bai5.model;

public class OrderItem {
    public Product product;
    public int quantity;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
