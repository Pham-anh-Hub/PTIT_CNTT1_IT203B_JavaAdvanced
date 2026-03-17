package PTIT_CNTT1_IT203B_Session07.Bai4;

import PTIT_CNTT1_IT203B_Session07.Bai1.Order;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderRepository implements OrderRepository{
    List<Order> databaseOrder = new ArrayList<>();
    @Override
    public void save(Order order) {
        databaseOrder.add(order);
        System.out.println("Lưu đơn hàng vào database: " + order.orderId);
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }
}
