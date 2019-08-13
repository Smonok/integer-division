package test.java.com.foxminded;

import main.java.com.foxminded.Division;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionTest {

    @Test
    void getMinuendShouldThrowIllegalArgumentExceptionWhenDivisorEqualsZero() {
        Division division = new Division();
        int dividend = 5;
        int divisor = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            division.getMinuend(dividend, divisor);
        });
    }

    @Test
    void getMinuendShouldReturnArrayWithOnlyDividerWhenDividendLessThanDivisor() {
        Division division = new Division();
        int dividend = 16;
        int divisor = 36;
        int[] expectedResult = { 16 };
        int[] actualResult = division.getMinuend(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void getMinuendShouldReturnArrayOfMinuendsWhenDividendBiggerThanDivisor() {
        Division division = new Division();
        int dividend = 78945;
        int divisor = 4;
        int[] expectedResult = { 7, 38, 29, 14, 25 };
        int[] actualResult = division.getMinuend(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void getMinuendShouldReturnArrayWithPositiveMinuendsWhenParametersNegative() {
        Division division = new Division();
        int dividend = -78945;
        int divisor = -4;
        int[] expectedResult = { 7, 38, 29, 14, 25 };
        int[] actualResult = division.getMinuend(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void getSubtrahendShouldThrowIllegalArgumentExceptionWhenDivisorEqualsZero() {
        Division division = new Division();
        int dividend = 5;
        int divisor = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            division.getSubtrahend(dividend, divisor);
        });
    }

    @Test
    void getSubtrahendShouldReturnArrayWithOnlyZeroWhenDividendLessThanDivisor() {
        Division division = new Division();
        int dividend = 16;
        int divisor = 36;
        int[] expectedResult = { 0 };
        int[] actualResult = division.getSubtrahend(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void getSubtrahendShouldReturnArrayOfSubtrahendsWhenDividendBiggerThanDivisor() {
        Division division = new Division();
        int dividend = 78945;
        int divisor = 4;
        int[] expectedResult = { 4, 36, 28, 12, 24 };
        int[] actualResult = division.getSubtrahend(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void getSubtrahendShouldReturnArrayWithPositiveSubtrahendsWhenParametersNegative() {
        Division division = new Division();
        int dividend = -78945;
        int divisor = -4;
        int[] expectedResult = { 4, 36, 28, 12, 24 };
        int[] actualResult = division.getSubtrahend(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void firstDividendShouldThrowIllegalArgumentExceptionWhenDivisorEqualsZero() {
        Division division = new Division();
        int dividend = 5;
        int divisor = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            division.firstDividend(dividend, divisor);
        });
    }

    @Test
    void firstDividendShouldReturnDividendWhenDividendLessThanDivisor() {
        Division division = new Division();
        int dividend = 5;
        int divisor = 55;
        int expectedResult = 5;
        int actualResult = division.firstDividend(dividend, divisor);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void firstDividendShouldReturnFirstDividendWhenDividendBiggerThanDivisor() {
        Division division = new Division();
        int dividend = 78945;
        int divisor = 4;
        int expectedResult = 7;
        int actualResult = division.firstDividend(dividend, divisor);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void numberDigitsShouldReturnArrayOfDigitsWhenPositiveNumber() {
        Division division = new Division();
        int number = 78945;
        int[] expectedResult = { 7, 8, 9, 4, 5 };
        int[] actualResult = division.numberDigits(number);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void numberDigitsShouldReturnArrayOfDigitsWhenNegativeNumber() {
        Division division = new Division();
        int number = -78945;
        int[] expectedResult = { 7, 8, 9, 4, 5 };
        int[] actualResult = division.numberDigits(number);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void numberLengthShouldReturnNumberOfDigitsWhenPositiveNumber() {
        Division division = new Division();
        int number = 78945;
        int expectedResult = 5;
        int actualResult = division.numberLength(number);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void numberLengthShouldReturnNumberOfOnlyDigitsWhenNegativeNumber() {
        Division division = new Division();
        int number = -78945;
        int expectedResult = 5;
        int actualResult = division.numberLength(number);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeMinusShouldReturnNumberWithoutMinusWhenNegative() {
        Division division = new Division();
        int number = -78;
        int expectedResult = 78;
        int actualResult = division.removeMinus(number);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeMinusShouldReturnSameNumberWhenPositive() {
        Division division = new Division();
        int number = 78;
        int expectedResult = 78;
        int actualResult = division.removeMinus(number);

        assertEquals(expectedResult, actualResult);
    }
}
