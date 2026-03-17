package PTIT_CNTT1_IT203B_Session07.Bai3;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor(); // interface chung

        PaymentMethod cod = new CODPayment();
        PaymentMethod card = new CreditCardPayment();
        PaymentMethod momo = new MomoPayment();

        cod.doPayment(2000000);
        card.doPayment(3000000);

        // Thay thế CreditCardPayment bằng MomoPayment trong cùng interface
        paymentProcessor.processPayment(1000000, card);
        paymentProcessor.processPayment(1000000, momo);



    }
}
