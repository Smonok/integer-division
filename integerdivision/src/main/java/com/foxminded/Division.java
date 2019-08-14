package main.java.com.foxminded;

public class Division {

    public int[] getMinuend(int dividend, int divisor) {
        int[] minuend = new int[numberDigits(dividend / divisor).length];
        int currentDividend = firstDividend(dividend, divisor);
        int[] dividendDigits = numberDigits(dividend);
        int index = numberDigits(firstDividend(dividend, divisor)).length;

        minuend[0] = firstDividend(dividend, divisor);
        for (int i = 1; i < minuend.length; i++) {
            currentDividend = findCurrentDividend(currentDividend, divisor, dividendDigits[index]);
            index++;
            minuend[i] = currentDividend;
        }

        return minuend;
    }

    public int firstDividend(int dividend, int divisor) {
        if (removeMinus(dividend) < divisor) {
            return dividend;
        }

        int[] dividendDigits = numberDigits(dividend);
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

    private int findCurrentDividend(int currentDividend, int divisor, int nextDigit) {
        int difference = currentDividend % divisor;
        int dividend = difference * 10;
        dividend += nextDigit;

        return dividend;
    }

    public int[] getSubtrahend(int dividend, int divisor) {
        int[] subtrahend = new int[numberDigits(dividend / divisor).length];
        int[] resultDigits = numberDigits(dividend / divisor);

        for (int i = 0; i < subtrahend.length; i++) {
            subtrahend[i] = divisor * resultDigits[i];
        }

        return subtrahend;
    }

    public int[] numberDigits(int number) {
        String numberStr = Integer.toString(removeMinus(number));
        int[] digits = new int[numberStr.length()];

        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Character.getNumericValue(numberStr.charAt(i));
        }

        return digits;
    }

    public int removeMinus(int number) {
        if (number < 0) {
            number *= -1;
        }

        return number;
    }
}
