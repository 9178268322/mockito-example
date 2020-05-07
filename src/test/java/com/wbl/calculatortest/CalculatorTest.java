package com.wbl.calculatortest;

import com.wbl.calculator.Calculator;
import com.wbl.calservice.CalculatorService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 * This is calculator class test.
 */
public class CalculatorTest {

    /**
     * Calculator class is initialising.
     */
    private static Calculator cal;

    private static CalculatorService mockedService = mock(CalculatorService.class);

    @BeforeTest
    public void setUp() {
        cal = new Calculator();
        cal.setCalculatorService(mockedService);
    }

    @Test
    public void addTest() {
        when(mockedService.save(5, 2)).thenReturn(7);
        assertEquals(cal.add(5, 2), 7);
        verify(mockedService).save(5, 2);
    }

    @Test
    public void testSub() {
        when(mockedService.sub(5, 2)).thenReturn(3);
        assertEquals(cal.substraction(5, 2), 3);
        verify(mockedService).sub(5, 2);
    }

    @Test
    public void testMul() {
        when(mockedService.mul(5, 2)).thenReturn(10L);
        assertEquals(cal.multiplication(5, 2), 10);
        verify(mockedService).mul(5, 2);
    }
}
