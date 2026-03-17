package PTIT_CNTT1_IT203B_Session07.Bai4;

import PTIT_CNTT1_IT203B_Session07.Bai1.Customer;
import PTIT_CNTT1_IT203B_Session07.Bai1.Order;

public class OrderService {
    public OrderRepository orderRepo;
    public NotificationService noticeService;

    public OrderService(OrderRepository orderRepo, NotificationService noticeService) {
        this.orderRepo = orderRepo;
        this.noticeService = noticeService;
    }

    public void createOrder(Order order, Customer customer){
        orderRepo.save(order);
        noticeService.send(("Đơn hàng " + order.orderId + " đã được tạo"), customer.getEmail());
    }
}
