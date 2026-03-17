package PTIT_CNTT1_IT203B_Session07.Bai5.orderRepo;

import PTIT_CNTT1_IT203B_Session07.Bai5.model.Order;

import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository{
    List<Order> fileOrderRepo;

    public FileOrderRepository() {
        this.fileOrderRepo = new ArrayList<>();
    }

    @Override
    public void saveOrder(Order order) {
        fileOrderRepo.add(order);
    }

    @Override
    public List<Order> findAll() {
        return fileOrderRepo;
    }
}
