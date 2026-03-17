package PTIT_CNTT1_IT203B_Session07.Bai4;

import PTIT_CNTT1_IT203B_Session07.Bai1.Customer;
import PTIT_CNTT1_IT203B_Session07.Bai1.Order;

public class Main {
    public static void main(String[] args) {
        OrderRepository repo = new FileOrderRepository();
        NotificationService notice = new EmailService();


        OrderService orderService = new OrderService(repo, notice);

        orderService.createOrder(new Order(new Customer("example@gmail.com", "Ha Noi")));
    }
}
