package PTIT_CNTT1_IT203B_Session07.BTTH.discount.impl;

import PTIT_CNTT1_IT203B_Session07.BTTH.discount.DiscountStrategy;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return 0;
    }
}
