package PTIT_CNTT1_IT203B_Session07.BTTH.repository.impl;

import PTIT_CNTT1_IT203B_Session07.BTTH.model.Order;
import PTIT_CNTT1_IT203B_Session07.BTTH.repository.OrderRepository;

public class FileOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Đã lưu đơn hàng "+order.getOrderId()+" vào file!");
    }
}
