package com.poc.controller;

import com.poc.servicios.CalculatorService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import com.poc.servicios.CalculatorServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resources")
public class CalculatorController {

  
    @Autowired
    private CalculatorServiceInterface calculatorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);
    
    private TracerImpl tracer = new TracerImpl();


    @GetMapping(value = "/calculate")
    public ResponseEntity<Double> calculate(@RequestParam(name = "firstNumber") BigDecimal firstNumber,
                                            @RequestParam(name = "secondNumber") BigDecimal secondNumber,
                                            @RequestParam(name = "mathOperation") String mathOperation) {

        LOGGER.info("Let's calculate!");
        LOGGER.info("The operation is : {} {} {}", firstNumber, secondNumber, mathOperation);
        double result = this.calculatorService.calculate(firstNumber, secondNumber, mathOperation);
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
