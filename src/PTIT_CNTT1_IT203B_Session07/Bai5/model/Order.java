package PTIT_CNTT1_IT203B_Session07.Bai5.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    public String pId;
    public List<OrderItem> productMap;
    public boolean status;
    public Customer customer;

    public Order(Customer customer) {
        this.productMap = new ArrayList<>();
        this.pId = "OR" + String.format("%04d", productMap.size() + 1);
        this.status = false; // chua thanh toan
        this.customer = customer;
    }

    public double getTotalOrder(){
        double total = 0;
        for (OrderItem item : productMap) {
            total += item.product.price * item.quantity;
        }
        return total;
    }
}
