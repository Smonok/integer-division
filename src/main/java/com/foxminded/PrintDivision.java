package main.java.com.foxminded;

import java.util.Collections;

public class PrintDivision {

    private final Division division = new Division();

    public String printIntegerDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder divisionResult = new StringBuilder();
        int resultLength = division.numberLength(dividend / divisor);
        int[] minuend = division.getMinuend(dividend, divisor);
        int[] subtrahend = division.getSubtrahend(dividend, divisor);

        divisionResult.append(header(dividend, divisor));
        for (int i = 1; i < resultLength; i++) {
            divisionResult.append(body(minuend, subtrahend, dividend, i));
        }

        return divisionResult.toString();
    }

    private String header(int dividend, int divisor) {
        int firstDividend = division.firstDividend(dividend, divisor);
        int firstDividendLength = division.numberLength(firstDividend);
        int[] resultDigits = division.numberDigits(dividend / divisor);
        int resultLength = division.numberLength(dividend / divisor);
        int firstSubtrahend = division.removeMinus(divisor) * resultDigits[0];
        int dividendLength = division.numberLength(dividend);
        int indent = 1;
        String header = "";

        if (dividend / divisor < 0) {
            resultLength++;
        }
        if (dividend < 0) {
            indent++;
        }

        header += "_" + dividend + "|" + divisor + "\n";

        header += String.format("%" + (indent + firstDividendLength) + "d", firstSubtrahend);
        header += String.format("%" + (1 + dividendLength - firstDividendLength) + "s", "|");
        header += String.format(String.join("", Collections.nCopies(resultLength, "-")) + "\n");

        header += String.format("%" + (indent + firstDividendLength) + "s",
                String.join("", Collections.nCopies(firstDividendLength, "-")));
        header += String.format("%" + (1 + dividendLength - firstDividendLength) + "s", "|");
        header += String.format("%d\n", (dividend / divisor));

        return header;
    }

    private String body(int[] minuend, int[] subtrahend, int dividend, int index) {
        String body = "";
        int firstminuendLength = division.numberLength(minuend[0]);
        int minuendLength = division.numberLength(minuend[index]);
        int indent = firstminuendLength - minuendLength + index + 1;

        if (dividend < 0) {
            indent++;
        }

        int subtrahendIndent = division.numberLength(minuend[index]) + indent;

        body += String.format("%" + (indent) + "s%d\n", "_", minuend[index]);
        body += String.format("%" + (subtrahendIndent) + "d\n", subtrahend[index]);
        body += String.format("%" + (subtrahendIndent) + "s\n",
                String.join("", Collections.nCopies(minuendLength, "-")));

        if (index == minuend.length - 1) {
            int remainder = minuend[index] - subtrahend[index];
            body += String.format("%" + (subtrahendIndent) + "d\n", division.removeMinus(remainder));
        }

        return body;
    }
}
