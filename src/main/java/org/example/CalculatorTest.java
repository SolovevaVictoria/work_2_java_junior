package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void testSum() {
        Calculator calculator = new Calculator();
        int actual = calculator.sum(3, 4);
        Assertions.assertEquals(7, actual);
    }
}
