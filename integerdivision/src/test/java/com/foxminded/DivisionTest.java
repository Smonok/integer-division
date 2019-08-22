package com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionTest {

    @Test
    void computeMinuendsArrayShouldReturnArrayWithOnlyDividerWhenDividendLessThanDivisor() {
        Division division = new Division();
        int dividend = 16;
        int divisor = 36;
        int[] expectedResult = { 16 };
        int[] actualResult = division.computeMinuendsArray(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void computeMinuendsArrayShouldReturnArrayOfMinuendsWhenDividendBiggerThanDivisor() {
        Division division = new Division();
        int dividend = 78945;
        int divisor = 4;
        int[] expectedResult = { 7, 38, 29, 14, 25 };
        int[] actualResult = division.computeMinuendsArray(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void computeMinuendsArrayShouldReturnArrayWithPositiveMinuendsWhenParametersNegative() {
        Division division = new Division();
        int dividend = -78945;
        int divisor = -4;
        int[] expectedResult = { 7, 38, 29, 14, 25 };
        int[] actualResult = division.computeMinuendsArray(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void computeSubtrahendsArrayShouldReturnArrayWithOnlyZeroWhenDividendLessThanDivisor() {
        Division division = new Division();
        int dividend = 16;
        int divisor = 36;
        int[] expectedResult = { 0 };
        int[] actualResult = division.computeSubtrahendsArray(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void computeSubtrahendsArrayShouldReturnArrayOfSubtrahendsWhenDividendBiggerThanDivisor() {
        Division division = new Division();
        int dividend = 78945;
        int divisor = 4;
        int[] expectedResult = { 4, 36, 28, 12, 24 };
        int[] actualResult = division.computeSubtrahendsArray(dividend, divisor);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void computeFirstDividendShouldReturnDividendWhenDividendLessThanDivisor() {
        Division division = new Division();
        int dividend = 5;
        int divisor = 55;
        int expectedResult = 5;
        int actualResult = division.computeFirstDividend(dividend, divisor);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void computeFirstDividendShouldReturncomputeFirstDividendWhenDividendBiggerThanDivisor() {
        Division division = new Division();
        int dividend = 78945;
        int divisor = 4;
        int expectedResult = 7;
        int actualResult = division.computeFirstDividend(dividend, divisor);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void toDigitsArrayShouldReturnArrayOfDigitsWhenPositiveNumber() {
        Division division = new Division();
        int number = 78945;
        int[] expectedResult = { 7, 8, 9, 4, 5 };
        int[] actualResult = division.toDigitsArray(number);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void toDigitsArrayShouldReturnArrayOfDigitsWhenNegativeNumber() {
        Division division = new Division();
        int number = -78945;
        int[] expectedResult = { 7, 8, 9, 4, 5 };
        int[] actualResult = division.toDigitsArray(number);

        assertArrayEquals(expectedResult, actualResult);
    }
}
