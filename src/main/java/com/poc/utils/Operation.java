package com.poc.utils;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Operation {
    SUMA("+"),
    RESTA("-");

    private static final Operation[] mathOperation = new Operation[]{SUMA, RESTA};

    private final String mathematicalSign;

    Operation(String mathematicalSign) {
        this.mathematicalSign = mathematicalSign;
    }

    private String getMathematicalSign() {
        return this.mathematicalSign;
    }

    @JsonCreator
    public static Operation getOperation(String valor) {

        for (int i = 0; i < mathOperation.length; ++i) {
            Operation mathOp = mathOperation[i];
            if (valor.equalsIgnoreCase(mathOp.name()) ||
                    valor.equalsIgnoreCase(mathOp.getMathematicalSign())) {
                return mathOp;
            }
        }

        return null;
    }
}
