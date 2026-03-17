package PTIT_CNTT1_IT203B_Session07.Bai5;

import PTIT_CNTT1_IT203B_Session07.Bai5.model.Customer;
import PTIT_CNTT1_IT203B_Session07.Bai5.model.Order;
import PTIT_CNTT1_IT203B_Session07.Bai5.model.OrderItem;
import PTIT_CNTT1_IT203B_Session07.Bai5.model.Product;
import PTIT_CNTT1_IT203B_Session07.Bai5.notice.NotificationService;
import PTIT_CNTT1_IT203B_Session07.Bai5.orderRepo.OrderRepository;

import java.util.Scanner;
import java.util.ArrayList;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notificationService;
    private Scanner scanner = new Scanner(System.in);

    public OrderService(OrderRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order newOrder, Customer customer) {
        // Bước 4: Lưu đơn hàng
        repository.saveOrder(newOrder);
        notificationService.send(customer, newOrder);

        System.out.println("=> Đã lưu đơn hàng thành công với mã: " + newOrder.pId);
    }
}