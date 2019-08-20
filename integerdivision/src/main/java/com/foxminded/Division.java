package com.foxminded;

public class Division {

    int[] getMinuendsArray(int dividend, int divisor) {
        int[] minuend = new int[getNumberDigits(dividend / divisor).length];
        int currentDividend = getFirstDividend(dividend, divisor);
        int[] dividendDigits = getNumberDigits(dividend);
        int index = getNumberDigits(getFirstDividend(dividend, divisor)).length;

        minuend[0] = getFirstDividend(dividend, divisor);
        for (int i = 1; i < minuend.length; i++) {
            currentDividend = getCurrentDividend(currentDividend, divisor, dividendDigits[index]);
            index++;
            minuend[i] = currentDividend;
        }

        return minuend;
    }

    int getFirstDividend(int dividend, int divisor) {
        if (Math.abs(dividend) < divisor) {
            return dividend;
        }

        int[] dividendDigits = getNumberDigits(dividend);
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

    private int getCurrentDividend(int currentDividend, int divisor, int nextDigit) {
        int difference = currentDividend % divisor;
        int dividend = difference * 10;
        dividend += nextDigit;

        return dividend;
    }

    int[] getSubtrahendsArray(int dividend, int divisor) {
        int[] subtrahend = new int[getNumberDigits(dividend / divisor).length];
        int[] resultDigits = getNumberDigits(dividend / divisor);

        for (int i = 0; i < subtrahend.length; i++) {
            subtrahend[i] = divisor * resultDigits[i];
        }

        return subtrahend;
    }

    int[] getNumberDigits(int number) {
        String numberStr = Integer.toString(number);
        int[] digits = new int[numberStr.length()];

        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Character.getNumericValue(numberStr.charAt(i));
        }

        return digits;
    }
}
