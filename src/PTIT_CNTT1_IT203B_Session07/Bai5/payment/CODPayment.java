package PTIT_CNTT1_IT203B_Session07.Bai5.payment;

import PTIT_CNTT1_IT203B_Session07.Bai5.model.Order;

import java.text.NumberFormat;

public class CODPayment implements PaymentMethod{
    @Override
    public void doPayment(double amount) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Thanh toán COD " + amount + "VND - Thành công");
    }
}
