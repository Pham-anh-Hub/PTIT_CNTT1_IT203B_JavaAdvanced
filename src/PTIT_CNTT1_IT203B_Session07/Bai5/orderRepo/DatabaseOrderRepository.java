package PTIT_CNTT1_IT203B_Session07.Bai5.orderRepo;

import PTIT_CNTT1_IT203B_Session07.Bai5.model.Order;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderRepository implements OrderRepository{
    List<Order> databaseOrderRepo;

    public DatabaseOrderRepository() {
        this.databaseOrderRepo = new ArrayList<>();
    }

    @Override
    public void saveOrder(Order order) {
        this.databaseOrderRepo.add(order);
    }


    @Override
    public List<Order> findAll() {
        return this.databaseOrderRepo;
    }
}
