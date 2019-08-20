package com.foxminded;

import java.util.Collections;

public class PrintDivision {

    public String integerDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }

        Division division = new Division();
        StringBuilder divisionResult = new StringBuilder(getHeader(dividend, divisor, division));
        int[] minuend = division.getMinuendsArray(Math.abs(dividend), Math.abs(divisor));
        int[] subtrahend = division.getSubtrahendsArray(Math.abs(dividend), Math.abs(divisor));

        for (int i = 0; i < minuend.length; i++) {
            int indent = getIndent(minuend, dividend, i);
            int subtrahendIndent = division.getNumberDigits(minuend[i]).length + indent;
            int minuendLength = division.getNumberDigits(minuend[i]).length;

            if (i != 0) {
                divisionResult.append(getMinuend(minuend[i], indent));
                divisionResult.append(getSubtrahend(subtrahend[i], subtrahendIndent));
                divisionResult.append(getSeparator(minuendLength, subtrahendIndent));
            }
            if (i == minuend.length - 1) {
                divisionResult.append(getRemainder(minuend, subtrahend, subtrahendIndent));
            }
        }

        return divisionResult.toString();
    }

    private String getHeader(int dividend, int divisor, Division division) {
        int result = dividend / divisor;
        int indent = 1;
        StringBuilder header = new StringBuilder("_" + dividend + "|" + divisor + "\n");

        if (dividend < 0) {
            indent++;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int firstDividend = division.getFirstDividend(dividend, divisor);
        int firstDividendLength = division.getNumberDigits(firstDividend).length;
        int resultLength = division.getNumberDigits(dividend / divisor).length;
        int dividendLength = division.getNumberDigits(dividend).length;
        int[] resultDigits = division.getNumberDigits(dividend / divisor);
        int firstSubtrahend = divisor * resultDigits[0];
        int firstSubtrahendIndent = indent + firstDividendLength;
        int separatorIndent = dividendLength - firstDividendLength + 1;

        if (result < 0) {
            resultLength++;
        }

        header.append(String.format("%" + firstSubtrahendIndent + "d", firstSubtrahend));
        header.append(String.format("%" + separatorIndent + "s%s\n", "|",
                String.join("", Collections.nCopies(resultLength, "-"))));

        header.append(String.format("%" + firstSubtrahendIndent + "s",
                String.join("", Collections.nCopies(firstDividendLength, "-"))));
        header.append(String.format("%" + separatorIndent + "s%d\n", "|", result));

        return header.toString();
    }

    private String getMinuend(int minuend, int indent) {
        return String.format("%" + indent + "s%d\n", "_", minuend);
    }

    private String getSubtrahend(int subtrahend, int subtrahendIndent) {
        return String.format("%" + subtrahendIndent + "d\n", subtrahend);
    }

    private String getSeparator(int minuendLength, int subtrahendIndent) {
        return String.format("%" + subtrahendIndent + "s\n", String.join("", Collections.nCopies(minuendLength, "-")));
    }

    private String getRemainder(int[] minuend, int[] subtrahend, int subtrahendIndent) {
        int index = minuend.length - 1;
        int remainder = minuend[index] - subtrahend[index];

        return String.format("%" + subtrahendIndent + "d\n", remainder);
    }

    private int getIndent(int[] minuend, int dividend, int index) {
        Division division = new Division();
        int firstMinuendLength = division.getNumberDigits(minuend[0]).length;
        int minuendLength = division.getNumberDigits(minuend[index]).length;

        if (dividend < 0) {
            firstMinuendLength++;
        }

        return firstMinuendLength - minuendLength + index + 1;
    }
}
