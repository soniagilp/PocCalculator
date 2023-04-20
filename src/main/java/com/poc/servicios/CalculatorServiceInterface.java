package com.poc.servicios;


import java.math.BigDecimal;

public interface CalculatorServiceInterface {

    /**
     * Method for calculation for given numbers and operator type
     * 
     * @param firstNumber
     * @param secondNumber
     * @param mathOperation sumar, restar
     * @return operation result
     */
    double calculate(BigDecimal firstNumber, BigDecimal secondNumber, String mathOperation);
}
