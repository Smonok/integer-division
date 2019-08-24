package com.foxminded.integerdivision;

public class Digits {

    public static int[] toDigitsArray(int number) {
        String numberStr = Integer.toString(Math.abs(number));
        int[] digits = new int[numberStr.length()];

        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Character.getNumericValue(numberStr.charAt(i));
        }

        return digits;
    }
}
