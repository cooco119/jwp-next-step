package com.cooco119.jwpnextstep.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyCalculatorTest {

    private MyCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new MyCalculator();
    }

    @Test
    public void Calculator_should_return_zero_when_empty_input() {
        assertEquals(0, calculator.eval(""));
    }

    @Test
    public void Calculator_should_return_asis_when_no_separators() {
        assertEquals(2, calculator.eval("2"));
    }

    @Test
    public void Calculator_should_return_sum_of_values_separated_only_with_comma() {
        var result = calculator.eval("1,3,5");
        assertEquals(1+3+5, result);
    }

    @Test
    public void Calculator_should_return_sum_of_values_separated_only_with_colons() {
        var result = calculator.eval("1:3:5");
        assertEquals(1+3+5, result);
    }

    @Test
    public void Calculator_should_return_sum_of_values_separated_with_both_comma_and_colons() {
        var result = calculator.eval("1,3:5");
        assertEquals(1+3+5, result);
    }

    @Test
    public void Calculator_should_return_sum_with_only_custom_separators() {
        var result = calculator.eval("//;\n1;2;3");
        assertEquals(1+2+3, result);
    }

    @Test
    public void Calculator_should_throw_RuntimeException_for_negative_input() {
        assertThrows(RuntimeException.class, () -> calculator.eval("-1,2:3"));
    }

    @Test
    public void Calculator_should_throw_RuntimeException_for_negative_input_with_custom_separators() {
        assertThrows(RuntimeException.class, () -> calculator.eval("//;\n-1;2;3"));
    }
}
