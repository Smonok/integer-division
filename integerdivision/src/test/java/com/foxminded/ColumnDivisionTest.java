package com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ColumnDivisionTest {

    @Test
    void integerDivisionShouldThrowIllegalArgumentExceptionWhenDivisorEqualsZero() {
        ColumnDivision division = new ColumnDivision();
        int dividend = 5;
        int divisor = 0;
        
        assertThrows(IllegalArgumentException.class, () -> {
            division.integerDivision(dividend, divisor);
        });
    }

    @Test
    void integerDivisionShouldReturnHeaderAndZeroRemainderWhenDividendZero() {
        ColumnDivision division = new ColumnDivision();
        int dividend = 0;
        int divisor = 334;
        String expectedResult = "_0|334\n" + 
                                " 0|-\n" + 
                                " -|0\n" +
                                " 0\n";
        String actualResult = division.integerDivision(dividend, divisor);
       
        assertEquals(expectedResult, actualResult);   
    }
    
    @Test
    void integerDivisionShouldReturnHeaderAndRemainderWhenDividendLessThanDivisor() {
        ColumnDivision division = new ColumnDivision();
        int dividend = 78;
        int divisor = 334;
        String expectedResult = "_78|334\n" + 
                                "  0|-\n" + 
                                " --|0\n" +
                                " 78\n";
        String actualResult = division.integerDivision(dividend, divisor);
        
        assertEquals(expectedResult, actualResult);   
    }
    
    @Test
    void integerDivisionShouldReturnHeaderAndRemainderWhenResultIsSingleDigitNumber() {
        ColumnDivision division = new ColumnDivision();
        int dividend = 36;
        int divisor = 24;
        String expectedResult = "_36|24\n" + 
                                " 24|-\n" + 
                                " --|1\n" + 
                                " 12\n";
        String actualResult = division.integerDivision(dividend, divisor);
        
        assertEquals(expectedResult, actualResult);   
    }
    
    @Test
    void integerDivisionShouldReturnDivisionWhenDividendBiggerThanDivisorAndTheyArePositive() {
        ColumnDivision division = new ColumnDivision();
        int dividend = 24321;
        int divisor = 19;
        String expectedResult = "_24321|19\n" + 
                                " 19   |----\n" + 
                                " --   |1280\n" + 
                                " _53\n" + 
                                "  38\n" + 
                                "  --\n" + 
                                " _152\n" + 
                                "  152\n" + 
                                "  ---\n" + 
                                "    _1\n" + 
                                "     0\n" + 
                                "     -\n" + 
                                "     1\n";
        String actualResult = division.integerDivision(dividend, divisor);
        
        assertEquals(expectedResult, actualResult);   
    }
    
    @Test
    void integerDivisionShouldReturnDivisionWithMinusesOnlyInHeaderWhenDividendNegative() {
        ColumnDivision division = new ColumnDivision();
        int dividend = -78945;
        int divisor = 16;
        String expectedResult = "_-78945|16\n" + 
                                "  64   |-----\n" + 
                                "  --   |-4934\n" + 
                                " _149\n" + 
                                "  144\n" + 
                                "  ---\n" + 
                                "   _54\n" + 
                                "    48\n" + 
                                "    --\n" + 
                                "    _65\n" + 
                                "     64\n" + 
                                "     --\n" + 
                                "      1\n";
        String actualResult = division.integerDivision(dividend, divisor);
        
        assertEquals(expectedResult, actualResult);   
    }
    
    @Test
    void integerDivisionShouldReturnDivisionWithMinusesOnlyInHeaderWhenDivisorNegative() {
        ColumnDivision division = new ColumnDivision();
        int dividend = 78945;
        int divisor = -26;
        String expectedResult = "_78945|-26\n" + 
                                " 78   |-----\n" + 
                                " --   |-3036\n" + 
                                "  _9\n" + 
                                "   0\n" + 
                                "   -\n" + 
                                "  _94\n" + 
                                "   78\n" + 
                                "   --\n" + 
                                "  _165\n" + 
                                "   156\n" + 
                                "   ---\n" + 
                                "     9\n";
        String actualResult = division.integerDivision(dividend, divisor);
        
        assertEquals(expectedResult, actualResult);   
    }
    
    @Test
    void integerDivisionShouldReturnDivisionWithMinusesOnlyInHeaderWhenBothParametersNegative() {
        ColumnDivision division = new ColumnDivision();
        int dividend = -23234;
        int divisor = -121;
        String expectedResult = "_-23234|-121\n" + 
                                "  121  |---\n" + 
                                "  ---  |192\n" + 
                                " _1113\n" + 
                                "  1089\n" + 
                                "  ----\n" + 
                                "   _244\n" + 
                                "    242\n" + 
                                "    ---\n" + 
                                "      2\n";
        String actualResult = division.integerDivision(dividend, divisor);
       
        assertEquals(expectedResult, actualResult);   
    }    
}
