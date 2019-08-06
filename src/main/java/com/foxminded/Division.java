package main.java.com.foxminded;

import java.util.Collections;

public class Division {

    public int integerDivision(int dividend, int divider) {
        if (divider == 0 || divider < dividend) {
            throw new IllegalArgumentException();
        }

        int[] dividendDigits = digitsArrayFromNumber(dividend);
        int[] resultDigits = digitsArrayFromNumber((dividend / divider));
        int currentDividend = firstDivident(dividend, divider);
        int firstDividendLength = digitsArrayFromNumber(currentDividend).length;
        int index = 1;
        int subtrahend = 0;

        printHeader(dividend, divider);
        for (int i = firstDividendLength - 1; i < dividendDigits.length; i++) {
            int remainder = currentDividend % divider;

            if (i != dividendDigits.length - 1) {
                currentDividend = currentDividend(remainder, dividendDigits[i + 1]);
                subtrahend = divider * resultDigits[index];
                index++;
                printBody(currentDividend, subtrahend, firstDividendLength, i);
            } else {
                printLastRemainder(subtrahend, remainder, i);
            }
        }

        return dividend / divider;
    }

    private void printHeader(int dividend, int divider) {
        int firstDividendLength = digitsArrayFromNumber(firstDivident(dividend, divider)).length;
        int dividendLength = digitsArrayFromNumber(dividend).length;
        int resultLength = digitsArrayFromNumber(dividend / divider).length;
        int dividerLength = digitsArrayFromNumber(divider).length;
        int[] resultDigits = digitsArrayFromNumber((dividend / divider));
        int FirstSubtrahend = divider * resultDigits[0];

        System.out.format("_%d|%d\n", dividend, divider);

        System.out.format("%" + (1 + firstDividendLength) + "d", FirstSubtrahend);
        System.out.format("%" + (1 + dividendLength - firstDividendLength) + "s", "|");
        System.out.format(String.join("", Collections.nCopies(resultLength, "-")) + "\n");

        System.out.format("%" + (1 + dividerLength) + "s", String.join("", Collections.nCopies(dividerLength, "-")));
        System.out.format("%" + (1 + dividendLength - dividerLength) + "s", "|");
        System.out.format("%d\n", (dividend / divider));
    }

    private void printBody(int currentDividend, int subtrahend, int firstDividendLength, int indent) {
        int currentDividendLength = digitsArrayFromNumber(currentDividend).length;

        if (firstDividendLength == 1) {
            indent++;
        }
        System.out.format("%" + indent + "s%d\n", "_", currentDividend);
        System.out.format("%" + (currentDividendLength + indent) + "d\n", subtrahend);
        System.out.format("%" + (currentDividendLength + indent) + "s\n",
                String.join("", Collections.nCopies(currentDividendLength, "-")));
    }

    private void printLastRemainder(int subtrahend, int remainder, int indent) {
        int subtrahendLength = digitsArrayFromNumber(subtrahend).length;

        System.out.format("%" + (subtrahendLength + indent) + "d\n", remainder);
    }

    private int[] digitsArrayFromNumber(int number) {
        String numberStr = Integer.toString(number);
        int[] digits = new int[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = numberStr.charAt(i) - '0';
        }

        return digits;
    }

    private int firstDivident(int dividend, int divider) {
        int[] dividendDigits = digitsArrayFromNumber(dividend);
        int firstDivident = dividendDigits[0];
        int index = 0;
        for (int i = 0; i < dividendDigits.length; i++) {
            if (firstDivident < divider) {
                firstDivident *= 10;
                firstDivident += dividendDigits[index + 1];
                index++;
            }
        }

        return firstDivident;
    }

    private int currentDividend(int remainder, int nextDigit) {
        int dividend = 0;
        dividend = remainder * 10;
        dividend += nextDigit;

        return dividend;
    }
}
