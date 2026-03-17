package PTIT_CNTT1_IT203B_Session07.Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    // Lưu danh sách đơng hàng đã tạo
    public List<Order> orderList;

    public OrderRepository() {
        this.orderList = new ArrayList<>();
    }
    public Order searchOrder(String orderId){
        Optional<Order> target = orderList.stream().filter((Order o) -> o.orderId.equalsIgnoreCase(orderId)).findFirst();
        if (target.isEmpty()) return null;

        return target.get();
    }
}
