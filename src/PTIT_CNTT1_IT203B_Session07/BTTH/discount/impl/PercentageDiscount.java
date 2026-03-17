package PTIT_CNTT1_IT203B_Session07.BTTH.discount.impl;

import PTIT_CNTT1_IT203B_Session07.BTTH.discount.DiscountStrategy;

public class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double total) {
        return percentage * total;
    }
}
