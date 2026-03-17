package PTIT_CNTT1_IT203B_Session07.Bai4;

import PTIT_CNTT1_IT203B_Session07.Bai1.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);

    List<Order> findAll();
}
