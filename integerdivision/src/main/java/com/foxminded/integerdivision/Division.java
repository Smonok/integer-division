package com.foxminded.integerdivision;

public class Division {

    int[] computeMinuendsArray(int dividend, int divisor) {
        int[] minuend = new int[DivisionUtil.toDigitsArray(dividend / divisor).length];
        int currentDividend = computeFirstDividend(dividend, divisor);
        int[] dividendDigits = DivisionUtil.toDigitsArray(dividend);
        int index = DivisionUtil.toDigitsArray(computeFirstDividend(dividend, divisor)).length;

        minuend[0] = computeFirstDividend(dividend, divisor);
        for (int i = 1; i < minuend.length; i++) {
            currentDividend = computeCurrentDividend(currentDividend, divisor, dividendDigits[index]);
            index++;
            minuend[i] = currentDividend;
        }

        return minuend;
    }

    int computeFirstDividend(int dividend, int divisor) {
        if (Math.abs(dividend) < divisor) {
            return dividend;
        }

        int[] dividendDigits = DivisionUtil.toDigitsArray(dividend);
        int firstDividend = dividendDigits[0];
        int index = 0;

        for (int i = 0; i < dividendDigits.length; i++) {
            if (firstDividend < divisor) {
                firstDividend *= 10;
                firstDividend += dividendDigits[index + 1];
                index++;
            }
        }

        return firstDividend;
    }

    private int computeCurrentDividend(int currentDividend, int divisor, int nextDigit) {
        int difference = currentDividend % divisor;
        int dividend = difference * 10;
        dividend += nextDigit;

        return dividend;
    }

    int[] computeSubtrahendsArray(int dividend, int divisor) {
        int[] subtrahend = new int[DivisionUtil.toDigitsArray(dividend / divisor).length];
        int[] resultDigits = DivisionUtil.toDigitsArray(dividend / divisor);

        for (int i = 0; i < subtrahend.length; i++) {
            subtrahend[i] = divisor * resultDigits[i];
        }

        return subtrahend;
    }
}
