package PTIT_CNTT1_IT203B_Session07.Bai1;

import java.util.List;

public class OrderCalculator {
    public static double calculateTotalOrder(Order order){
        double totalOrder = 0;
        for (Product p : order.products.keySet()){
            totalOrder += (p.price * order.products.get(p));
        }
        return totalOrder;
    }
}
