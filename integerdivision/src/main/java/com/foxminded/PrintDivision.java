package main.java.com.foxminded;

import java.util.Collections;

public class PrintDivision {

    public String printIntegerDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }

        Division division = new Division();
        StringBuilder divisionResult = new StringBuilder(getHeader(dividend, divisor));
        int result = division.removeMinus(dividend / divisor);
        int resultLength = division.numberDigits(result).length;
        int[] minuend = division.getMinuend(division.removeMinus(dividend), division.removeMinus(divisor));
        int[] subtrahend = division.getSubtrahend(division.removeMinus(dividend), division.removeMinus(divisor));

        for (int i = 1; i < resultLength; i++) {
            divisionResult.append(getBody(minuend, subtrahend, dividend, i));
        }
        divisionResult.append(getRemainder(minuend, subtrahend, dividend));

        return divisionResult.toString();
    }

    private String getHeader(int dividend, int divisor) {
        Division division = new Division();
        int result = dividend / divisor;
        int indent = 1;
        String header = "_" + dividend + "|" + divisor + "\n";

        if (dividend < 0) {
            indent++;
        }

        dividend = division.removeMinus(dividend);
        divisor = division.removeMinus(divisor);

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

    private String getBody(int[] minuend, int[] subtrahend, int dividend, int index) {
        Division division = new Division();
        String body = "";
        int firstMinuendLength = division.numberDigits(minuend[0]).length;
        int minuendLength = division.numberDigits(minuend[index]).length;
        int indent = firstMinuendLength - minuendLength + index + 1;

        if (dividend < 0) {
            indent++;
        }

        int subtrahendIndent = division.numberDigits(minuend[index]).length + indent;

        body += String.format("%" + indent + "s%d\n", "_", minuend[index]);
        body += String.format("%" + subtrahendIndent + "d\n", subtrahend[index]);
        body += String.format("%" + subtrahendIndent + "s\n", String.join("", Collections.nCopies(minuendLength, "-")));

        return body;
    }

    private String getRemainder(int[] minuend, int[] subtrahend, int dividend) {
        Division division = new Division();
        int index = minuend.length - 1;
        int firstminuendLength = division.numberDigits(minuend[0]).length;
        int minuendLength = division.numberDigits(minuend[index]).length;
        int indent = firstminuendLength - minuendLength + index + 1;
        int subtrahendIndent = division.numberDigits(minuend[index]).length + indent;
        int remainder = minuend[index] - subtrahend[index];

        if (dividend < 0) {
            subtrahendIndent++;
        }

        return String.format("%" + subtrahendIndent + "d\n", division.removeMinus(remainder));
    }
}
