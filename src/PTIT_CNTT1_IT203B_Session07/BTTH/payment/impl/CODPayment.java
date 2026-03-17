package PTIT_CNTT1_IT203B_Session07.BTTH.payment.impl;

import PTIT_CNTT1_IT203B_Session07.BTTH.payment.PaymentMethod;

import java.text.NumberFormat;

public class CODPayment implements PaymentMethod {
    @Override
    public boolean process(double amount) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        System.out.println("Đã thanh toán số tiền "+numberFormat.format(amount));
        return true;
    }
}
