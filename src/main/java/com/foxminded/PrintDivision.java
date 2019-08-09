package main.java.com.foxminded;

import java.util.Collections;

public class PrintDivision {

    private Division division = new Division();

    public void printIntegerDivision(int dividend, int divisor) {
        if (divisor <= 0 || dividend < 0 || dividend < divisor) {
            throw new IllegalArgumentException();
        }

        int resultLength = division.numberLength(dividend / divisor);
        int[] minuend = division.getMinuend(dividend, divisor);
        int[] subtrahend = division.getSubtrahend(dividend, divisor);

        System.out.format(header(dividend, divisor));
        for (int i = 1; i < resultLength; i++) {
            System.out.format(body(minuend, subtrahend, i));
        }
        System.out.format(remainder(minuend, subtrahend));
    }

    private String header(int dividend, int divisor) {
        int firstDividendLength = division.numberLength(division.firstDividend(dividend, divisor));
        int[] resultDigits = division.numberDigits((dividend / divisor));
        int resultLength = division.numberLength((dividend / divisor));
        int firstSubtrahend = divisor * resultDigits[0];
        int firstSubtrahendLength = division.numberDigits(firstSubtrahend).length;
        int dividendLength = division.numberLength(dividend);
        StringBuilder header = new StringBuilder();

        header.append("_" + dividend + "|" + divisor + "%n");

        header.append(String.format("%" + (1 + firstDividendLength) + "d", firstSubtrahend));
        header.append(String.format("%" + (1 + dividendLength - firstDividendLength) + "s", "|"));
        header.append(String.format(String.join("", Collections.nCopies(resultLength, "-")) + "%n"));

        header.append(String.format("%" + (1 + firstSubtrahendLength) + "s",
                String.join("", Collections.nCopies(firstSubtrahendLength, "-"))));
        header.append(String.format("%" + (1 + dividendLength - firstDividendLength) + "s", "|"));
        header.append(String.format("%d%n", (dividend / divisor)));

        return header.toString();
    }

    private String body(int[] minuend, int[] subtrahend, int index) {
        StringBuilder body = new StringBuilder();
        int indent = division.indent(minuend[0], subtrahend[0]);
        int subtrahendIndent = division.numberLength(minuend[index]) + indent;
        int minuendLength = division.numberLength(minuend[index]);

        body.append(String.format("%" + (indent + index) + "s%d%n", "_", minuend[index]));
        body.append(String.format("%" + (subtrahendIndent + index) + "d%n", subtrahend[index]));
        body.append(String.format("%" + (subtrahendIndent + index) + "s%n",
                String.join("", Collections.nCopies(minuendLength, "-"))));

        return body.toString();
    }

    private String remainder(int[] minuend, int[] subtrahend) {
        int indent = division.indent(minuend[0], subtrahend[0]);
        int index = minuend.length - 1;
        int subtrahendIndent = division.numberLength(minuend[index]) + indent;
        int remainder = minuend[index] - subtrahend[index];

        return String.format("%" + (subtrahendIndent + subtrahend.length - 1) + "d%n", remainder);
    }
}
