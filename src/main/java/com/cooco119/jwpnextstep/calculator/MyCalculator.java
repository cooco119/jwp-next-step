package com.cooco119.jwpnextstep.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCalculator {

    public int eval(String input) throws RuntimeException {
        if (input.length() == 0) {
            return 0;
        }

        var targetInput = input;
        var customOp = "";
        if (input.startsWith("//") && input.contains("\n")) {
            var customOpRegion = input.split("\\n")[0];
            targetInput = input.split("\\n")[1];
            customOp = customOpRegion.split("//")[1];
        }
        var ops = new StringBuilder();
        ops.append("[");
        ops.append(",");
        ops.append(":");
        if (!customOp.isEmpty()) {
            ops.append(customOp);
        }
        ops.append("]");
        var args = targetInput.split(ops.toString());
        var result = 0;
        for (var argStr : args) {
            var arg = Integer.parseInt(argStr);
            if (arg < 0) {
                throw new RuntimeException("value negative");
            }
            result += arg;
        }
        return result;
    }
}
