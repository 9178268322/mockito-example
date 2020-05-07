package com.wbl.calservice;

/**
 * This is calculator service interface.
 */
public interface CalculatorService {
    int save(int num1, int num2);

    int sub(int num1, int num2);

    long mul(int num1, int num2);

    double div(int num1, int num2);
}
