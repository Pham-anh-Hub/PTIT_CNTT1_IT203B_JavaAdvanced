package PTIT_CNTT1_IT203B_Session07.Bai5.notice;

import PTIT_CNTT1_IT203B_Session07.Bai5.model.Customer;
import PTIT_CNTT1_IT203B_Session07.Bai5.model.Order;

public class EmailNotification implements NotificationService{

    @Override
    public void send(Customer customer, Order order) {
        System.out.println("Đã gửi email xác nhận đơn hàng "+ order.pId + " đến khách hàng " + customer.name +" theo email" + customer.email);
    }
}
