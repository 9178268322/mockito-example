package com.wbl.calculator;

import com.wbl.calservice.CalculatorService;

/**
 * This is calculator class.
 */
public class Calculator {

    private static CalculatorService calculatorService;

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int add(int num1, int num2) {
        return calculatorService.save(num1, num2);
    }

    public int substraction(int num1, int num2) {
        return calculatorService.sub(num1, num2);
    }

    public long multiplication(int num1, int num2) {
        return calculatorService.mul(num1, num2);
    }

    public double division(int num1, int num2) {
        return calculatorService.div(num1, num2);
    }
}
