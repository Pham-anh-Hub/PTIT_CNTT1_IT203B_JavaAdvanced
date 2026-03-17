package PTIT_CNTT1_IT203B_Session07.Bai2;

public interface DiscountStrategy {

    default double applyDiscount(double totalAmount){
        return totalAmount;
    };
}
