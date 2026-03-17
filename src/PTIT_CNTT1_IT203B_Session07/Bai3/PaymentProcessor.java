package PTIT_CNTT1_IT203B_Session07.Bai3;

public class PaymentProcessor {
    public void processPayment (double amount, PaymentMethod method){
        if (method instanceof CODPayable cod){
            cod.doPayment(amount);
        } else if (method instanceof  CardPayable card) {
            card.doPayment(amount);
        } else if (method instanceof EWalletPayable eWallet) {
            eWallet.doPayment(amount);
        }
    }
}
