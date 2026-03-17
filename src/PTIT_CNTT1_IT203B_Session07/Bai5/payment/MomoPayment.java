package PTIT_CNTT1_IT203B_Session07.Bai5.payment;

import java.text.NumberFormat;

public class MomoPayment implements PaymentMethod{

    @Override
    public void doPayment(double amount) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Thanh toán với MoMo: " + amount + "VND - Thành công");
    }

//    @Override
//    public void doPayment(Order order) {
//        NumberFormat nf = NumberFormat.getNumberInstance();
//        System.out.println("Thanh toán với MoMo: " + order.getTotalOrder() + "VND - Thành công");
//        order.status = true; // Chuyển trạng thái thành đã thanh toán
//    }
}
