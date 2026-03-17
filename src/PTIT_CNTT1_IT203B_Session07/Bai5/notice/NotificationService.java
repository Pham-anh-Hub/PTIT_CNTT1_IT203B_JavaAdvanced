package PTIT_CNTT1_IT203B_Session07.Bai5.notice;

import PTIT_CNTT1_IT203B_Session07.Bai5.model.Customer;
import PTIT_CNTT1_IT203B_Session07.Bai5.model.Order;

public interface NotificationService {
    void send(Customer customer, Order order);
}
