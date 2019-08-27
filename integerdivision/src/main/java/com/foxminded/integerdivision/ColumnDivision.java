package com.foxminded.integerdivision;

import java.util.Collections;

public class ColumnDivision {

    public String integerDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }

        Division division = new Division();
        StringBuilder divisionResult = new StringBuilder(createHeader(dividend, divisor, division));
        int[] minuend = division.computeMinuendsArray(Math.abs(dividend), Math.abs(divisor));
        int[] subtrahend = division.computeSubtrahendsArray(Math.abs(dividend), Math.abs(divisor));

        for (int i = 0; i < minuend.length; i++) {
            int indent = computeIndent(minuend, dividend, i);
            int subtrahendIndent = DivisionUtil.toDigitsArray(minuend[i]).length + indent;
            int minuendLength = DivisionUtil.toDigitsArray(minuend[i]).length;

            if (i != 0) {
                divisionResult.append(createMinuend(minuend[i], indent))
                        .append(createSubtrahend(subtrahend[i], subtrahendIndent))
                        .append(createSeparator(minuendLength, subtrahendIndent));
            }
            if (i == minuend.length - 1) {
                divisionResult.append(createRemainder(minuend, subtrahend, subtrahendIndent));
            }
        }

        return divisionResult.toString();
    }

    private String createHeader(int dividend, int divisor, Division division) {
        int divisionResult = dividend / divisor;
        int indent = 1;
        StringBuilder header = new StringBuilder("_" + dividend + "|" + divisor + "\n");

        if (dividend < 0) {
            indent++;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int firstDividend = division.computeFirstDividend(dividend, divisor);
        int firstDividendLength = DivisionUtil.toDigitsArray(firstDividend).length;
        int divisionResultLength = DivisionUtil.toDigitsArray(dividend / divisor).length;
        int dividendLength = DivisionUtil.toDigitsArray(dividend).length;
        int[] divisionResultDigits = DivisionUtil.toDigitsArray(dividend / divisor);
        int firstSubtrahend = divisor * divisionResultDigits[0];
        int firstSubtrahendIndent = indent + firstDividendLength;
        int separatorIndent = dividendLength - firstDividendLength + 1;

        if (divisionResult < 0) {
            divisionResultLength++;
        }

        header.append(String.format("%" + firstSubtrahendIndent + "d", firstSubtrahend))
                .append(String.format("%" + separatorIndent + "s%s\n", "|",
                        String.join("", Collections.nCopies(divisionResultLength, "-"))))

                .append(String.format("%" + firstSubtrahendIndent + "s",
                        String.join("", Collections.nCopies(firstDividendLength, "-"))))
                .append(String.format("%" + separatorIndent + "s%d\n", "|", divisionResult));

        return header.toString();
    }

    private String createMinuend(int minuend, int indent) {
        return String.format("%" + indent + "s%d\n", "_", minuend);
    }

    private String createSubtrahend(int subtrahend, int subtrahendIndent) {
        return String.format("%" + subtrahendIndent + "d\n", subtrahend);
    }

    private String createSeparator(int minuendLength, int subtrahendIndent) {
        return String.format("%" + subtrahendIndent + "s\n", String.join("", Collections.nCopies(minuendLength, "-")));
    }

    private String createRemainder(int[] minuend, int[] subtrahend, int subtrahendIndent) {
        int index = minuend.length - 1;
        int remainder = minuend[index] - subtrahend[index];

        return String.format("%" + subtrahendIndent + "d\n", remainder);
    }

    private int computeIndent(int[] minuend, int dividend, int index) {
        int firstMinuendLength = DivisionUtil.toDigitsArray(minuend[0]).length;
        int minuendLength = DivisionUtil.toDigitsArray(minuend[index]).length;

        if (dividend < 0) {
            firstMinuendLength++;
        }

        return firstMinuendLength - minuendLength + index + 1;
    }
}
