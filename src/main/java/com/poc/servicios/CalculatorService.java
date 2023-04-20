package com.poc.servicios;

import com.poc.utils.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService implements CalculatorServiceInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);

    @Override
    public double calculate(BigDecimal firstNumber, BigDecimal secondNumber, String mathOperation) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Is calculating the result : {} {} {}", firstNumber, secondNumber, mathOperation);
        }

        Operation operacion = Operation.getOperation(mathOperation);

        if(operacion == null) {
            throw new RuntimeException("Operation not supported on this calculator with math operation: " + mathOperation);
        }

        switch (operacion) {
            case SUMA:
                return firstNumber.add(secondNumber).doubleValue();
            case RESTA:
                return firstNumber.subtract(secondNumber).doubleValue();
            default:
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error("This mathematical operation is not supported by this calculator: {}", operacion);
                }
                throw new RuntimeException("This mathematical operation cannot be calculated with a result: " + operacion.toString());

        }
    }
}
