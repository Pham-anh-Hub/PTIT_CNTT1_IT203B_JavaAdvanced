package PTIT_CNTT1_IT203B_Session07.BTTH.discount.impl;

import PTIT_CNTT1_IT203B_Session07.BTTH.discount.DiscountStrategy;

public class FixedDiscount implements DiscountStrategy {
    private double money;
    public FixedDiscount(double money) {
        this.money = money;
    }
    @Override
    public double applyDiscount(double total) {
        return money;
    }
}
