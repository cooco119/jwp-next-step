package com.cooco119.jwpnextstep.calculator.modules;

import java.util.Arrays;

public class ExpressionParser {

    private final String DEFAULT_OPERATORS = ",:";

    private String input = "";
    private String customOp = "";
    private String truncatedInput = "";


    public ExpressionParser(String input) {
        this.input = input;
    }

    public static ExpressionParser WithInput(String input) {
        return new ExpressionParser(input);
    }

    public int[] getOperands() {
        if(containsCustomOperator()) parseCustomOperator();
        var strArgs = getInput().split(getOperators());
        int[] result = parseOperandsToInt(strArgs);
        return result;
    }

    private boolean containsCustomOperator() {
        return input.startsWith("//") && input.contains("\n");
    }

    private void parseCustomOperator() {
        var customOpRegion = input.split("\\n")[0];
        truncatedInput = input.split("\\n")[1];
        customOp = customOpRegion.split("//")[1];
    }

    private String getInput() {
        if (customOperatorExists()) return truncatedInput;
        return input;
    }

    private boolean customOperatorExists() {
        return !customOp.isEmpty() && !truncatedInput.isEmpty();
    }

    private String getOperators() {
        var ops = new StringBuilder();
        ops.append("[");
        ops.append(DEFAULT_OPERATORS);
        if (customOperatorExists()) ops.append(customOp);
        ops.append("]");
        return ops.toString();
    }

    private int[] parseOperandsToInt(String[] argsStr) {
        return Arrays.stream(argsStr).mapToInt(Integer::parseInt).toArray();
    }
}
