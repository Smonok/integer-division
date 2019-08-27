package com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionUtilTest {

    @Test
    void toDigitsArrayShouldReturnArrayOfDigitsWhenPositiveNumber() {
        int number = 78945;
        int[] expectedResult = { 7, 8, 9, 4, 5 };
        int[] actualResult = DivisionUtil.toDigitsArray(number);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void toDigitsArrayShouldReturnArrayOfDigitsWhenNegativeNumber() {
        int number = -78945;
        int[] expectedResult = { 7, 8, 9, 4, 5 };
        int[] actualResult = DivisionUtil.toDigitsArray(number);

        assertArrayEquals(expectedResult, actualResult);
    }
}
