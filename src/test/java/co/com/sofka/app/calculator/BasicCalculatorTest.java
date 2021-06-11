package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorTest {
        private final BasicCalculator basicCalculator = new BasicCalculator();

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Double first, Double second, Double expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several subtract")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "1,    1,   0",
            "2,    1,   1",
            "100,  51, 49",
            "100,  1, 99"
    })
    public void severalSubtract(Double first, Double second, Double expectedResult) {
        assertEquals(expectedResult, basicCalculator.subtract(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several multiply")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "1,    2,   2",
            "10,  10, 100",
            "4,  4, 16"
    })
    public void severalMultiply(Double first, Double second, Double expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several divide")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0,    2,   0",
            "1,    1,   1",
            "6,    2,   3",
            "100,  50,  2",
            "25,   5,   5"
    })
    public void severalDivide(Double first, Double second, Double expectedResult) {
        assertEquals(expectedResult, basicCalculator.divide(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing divide cero")
    @ParameterizedTest(name = "{0} / {1}" )
    @CsvSource({
            "1,0",
            "0,0"
    })

    public void divideCero(Double first, Double second) {
        var response = assertThrows(RuntimeException.class, () ->{
            double result = basicCalculator.divide(first,second);
        });
        assertEquals("No se puede dividir por cero", response.getMessage());
    }


}

