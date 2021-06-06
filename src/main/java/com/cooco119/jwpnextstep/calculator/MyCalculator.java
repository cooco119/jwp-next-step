package com.cooco119.jwpnextstep.calculator;

import com.cooco119.jwpnextstep.calculator.modules.ExpressionParser;

public class MyCalculator {

    public MyCalculator() {
    }

    public int eval(String input) throws RuntimeException {
        if (!isInputValid(input)) {
            return 0;
        }

        var expressionParser = ExpressionParser.WithInput(input);
        return addIfAllPositive(expressionParser.getOperands());
    }

    private boolean isInputValid(String input) {
        return input != null && input.length() != 0;
    }

    private int addIfAllPositive(int[] args) {
        int result = 0;
        for (var arg : args) {
            if (arg < 0) {
                throw new RuntimeException("value negative");
            }
            result += arg;
        }
        return result;
    }
}
