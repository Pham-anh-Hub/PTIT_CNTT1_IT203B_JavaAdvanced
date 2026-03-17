package PTIT_CNTT1_IT203B_Session07.BTTH.test;

import PTIT_CNTT1_IT203B_Session07.BTTH.model.Order;
import PTIT_CNTT1_IT203B_Session07.BTTH.service.OrderService;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        Order order = new Order();
        orderService.processOrder(order);
    }
}
