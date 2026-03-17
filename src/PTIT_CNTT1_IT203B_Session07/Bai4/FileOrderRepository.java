package PTIT_CNTT1_IT203B_Session07.Bai4;

import PTIT_CNTT1_IT203B_Session07.Bai1.Order;

import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository{
    List<Order> orderRepo = new ArrayList<>();
    @Override
    public void save(Order order) {
        orderRepo.add(order);
        System.out.println("Lưu đơn hàng vào file: " + order.orderId);
    }

    @Override
    public List<Order> findAll() {
        return orderRepo;
    }
}
