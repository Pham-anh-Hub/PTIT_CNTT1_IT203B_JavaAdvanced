package PTIT_CNTT1_IT203B_Session07.Bai5.orderRepo;

import PTIT_CNTT1_IT203B_Session07.Bai5.model.Order;

import java.util.List;

public interface OrderRepository {
    void saveOrder(Order order);

    List<Order> findAll();
}
