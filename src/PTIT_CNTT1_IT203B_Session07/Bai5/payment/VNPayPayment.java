package PTIT_CNTT1_IT203B_Session07.Bai5.payment;

import java.text.NumberFormat;

public class VNPayPayment implements PaymentMethod{
    @Override
    public void doPayment(double amount) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Thanh toán với VNPay: " + amount + "VND - Thành công");
    }
}
