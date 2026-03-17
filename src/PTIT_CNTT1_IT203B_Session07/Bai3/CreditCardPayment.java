package PTIT_CNTT1_IT203B_Session07.Bai3;

import java.text.NumberFormat;

public class CreditCardPayment implements CardPayable{
    @Override
    public void doPayment(double amount) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + nf.format(amount) + " - Thành công");
    }
}
