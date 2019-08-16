package main.java.com.foxminded;

import java.util.Collections;

public class PrintDivision {

    public String printIntegerDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }

        Division division = new Division();
        StringBuilder divisionResult = new StringBuilder(getHeader(dividend, divisor, division));
        int[] minuend = division.getMinuend(Math.abs(dividend), Math.abs(divisor));
        int[] subtrahend = division.getSubtrahend(Math.abs(dividend), Math.abs(divisor));

        for (int i = 1; i < minuend.length; i++) {
            divisionResult.append(getBody(minuend, subtrahend, dividend, division, i));
        }
        divisionResult.append(getRemainder(minuend, subtrahend, dividend, division));

        return divisionResult.toString();
    }

    private String getHeader(int dividend, int divisor, Division division) {
        int result = dividend / divisor;
        int indent = 1;
        String header = "_" + dividend + "|" + divisor + "\n";

        if (dividend < 0) {
            indent++;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int firstDividend = division.firstDividend(dividend, divisor);
        int firstDividendLength = division.numberDigits(firstDividend).length;
        int resultLength = division.numberDigits(dividend / divisor).length;
        int dividendLength = division.numberDigits(dividend).length;
        int[] resultDigits = division.numberDigits(dividend / divisor);
        int firstSubtrahend = divisor * resultDigits[0];
        int firstSubtrahendIndent = indent + firstDividendLength;
        int separatorIndent = dividendLength - firstDividendLength + 1;

        if (result < 0) {
            resultLength++;
        }

        header += String.format("%" + firstSubtrahendIndent + "d", firstSubtrahend);
        header += String.format("%" + separatorIndent + "s%s\n", "|",
                String.join("", Collections.nCopies(resultLength, "-")));

        header += String.format("%" + firstSubtrahendIndent + "s",
                String.join("", Collections.nCopies(firstDividendLength, "-")));
        header += String.format("%" + separatorIndent + "s%d\n", "|", result);

        return header;
    }

    private String getBody(int[] minuend, int[] subtrahend, int dividend, Division division, int index) {
        int minuendLength = division.numberDigits(minuend[index]).length;
        int indent = getIndent(minuend, division, index);

        if (dividend < 0) {
            indent++;
        }

        int subtrahendIndent = division.numberDigits(minuend[index]).length + indent;

        String body = String.format("%" + indent + "s%d\n", "_", minuend[index]);
        body += String.format("%" + subtrahendIndent + "d\n", subtrahend[index]);
        body += String.format("%" + subtrahendIndent + "s\n", String.join("", Collections.nCopies(minuendLength, "-")));

        return body;
    }

    private String getRemainder(int[] minuend, int[] subtrahend, int dividend, Division division) {
        int index = minuend.length - 1;
        int indent = getIndent(minuend, division, index);
        int subtrahendIndent = division.numberDigits(minuend[index]).length + indent;
        int remainder = minuend[index] - subtrahend[index];

        if (dividend < 0) {
            subtrahendIndent++;
        }

        return String.format("%" + subtrahendIndent + "d\n", Math.abs(remainder));
    }

    private int getIndent(int[] minuend, Division division, int index) {
        int firstminuendLength = division.numberDigits(minuend[0]).length;
        int minuendLength = division.numberDigits(minuend[index]).length;

        return firstminuendLength - minuendLength + index + 1;
    }
}
