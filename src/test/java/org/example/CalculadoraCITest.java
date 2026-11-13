package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraCITest {

    @Test
    void deveSomarCorretamente() {
        CalculadoraCI calc = new CalculadoraCI();
        assertEquals(10, calc.somar(5, 5));
    }

    @Test
    void deveSubtrairCorretamente() {
        CalculadoraCI calc = new CalculadoraCI();
        assertEquals(4, calc.subtrair(10, 6));
    }
}