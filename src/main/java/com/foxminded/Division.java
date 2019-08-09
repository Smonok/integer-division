package main.java.com.foxminded;

public class Division {

    public int[] getMinuend(int dividend, int divisor) {
        if (divisor <= 0 || dividend < 0 || dividend < divisor) {
            throw new IllegalArgumentException();
        }
        return fillMinuend(dividend, divisor);
    }

    private int[] fillMinuend(int dividend, int divisor) {
        int[] minuend = new int[numberLength(dividend / divisor)];
        int currentDividend = firstDividend(dividend, divisor);
        int[] dividendDigits = numberDigits(dividend);
        int index = numberLength(firstDividend(dividend, divisor));

        minuend[0] = firstDividend(dividend, divisor);
        for (int i = 1; i < minuend.length; i++) {
            currentDividend = findCurrentDividend(difference(currentDividend, divisor), dividendDigits[index]);
            index++;
            minuend[i] = currentDividend;
        }

        return minuend;
    }

    public int firstDividend(int dividend, int divisor) {
        if (divisor <= 0 || dividend < 0 || dividend < divisor) {
            throw new IllegalArgumentException();
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

    private int findCurrentDividend(int difference, int nextDigit) {
        int dividend = difference * 10;
        dividend += nextDigit;

        return dividend;
    }

    private int difference(int currentDividend, int divisor) {
        return currentDividend % divisor;
    }

    public int[] getSubtrahend(int dividend, int divisor) {
        if (divisor <= 0 || dividend < 0 || dividend < divisor) {
            throw new IllegalArgumentException();
        }

        return fillSubtrahend(dividend, divisor);
    }

    private int[] fillSubtrahend(int dividend, int divisor) {
        int[] subtrahend = new int[numberLength(dividend / divisor)];
        int[] resultDigits = numberDigits(dividend / divisor);

        for (int i = 0; i < subtrahend.length; i++) {
            subtrahend[i] = divisor * resultDigits[i];
        }

        return subtrahend;
    }

    public int indent(int firstMinuend, int firstSubtrahend) {
        if (firstMinuend < 0 || firstSubtrahend < 0) {
            throw new IllegalArgumentException();
        }

        int firstMinuendLength = numberLength(firstMinuend);
        int difference = firstMinuend - firstSubtrahend;
        int differenceLength = numberLength(difference);
        int indent = firstMinuendLength - differenceLength;

        return indent;
    }

    public int numberLength(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }

        return numberDigits(number).length;
    }

    public int[] numberDigits(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }

        String numberStr = Integer.toString(number);
        int[] digits = new int[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = numberStr.charAt(i) - '0';
        }

        return digits;
    }
}
