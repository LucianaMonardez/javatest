package com.javatest.discounts;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class PriceCalculatorShould {
    PriceCalculator calculator = new PriceCalculator();

    @Test
    public void total_zero_when_there_are_prices() {
        assertThat( calculator.getTotal(), is(0.0));
    }
    @Test
    public void total_is_the_sum_of_prices() {
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);
        assertThat( calculator.getTotal(), is(25.7));
    }
    @Test
    public void apply_discount_to_prices() {

        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);
        calculator.setDiiscount(25);

        assertThat( calculator.getTotal(), is(150.0));
    }
}