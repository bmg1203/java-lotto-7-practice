package lotto.service;

import lotto.model.ErrorMessage;

import java.math.BigInteger;

public class Validator {
    public static void purchaseLottoValidate(String input) {
        readIntOnly(input);
    }

    public static void enterWinningNumberValidate(String input) {
        if ( !input.matches("[0-9,]*") ) {
            throw new IllegalArgumentException(ErrorMessage.NATURAL_NUMBERS_AND_COMMA_ONLY.getMessage());
        }
        String[] inputStringNumbers = input.split(",");
        for ( String inputStringNumber : inputStringNumbers) {
            BigInteger inputAmount = new BigInteger(inputStringNumber);
            if ( inputAmount.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                throw new IllegalArgumentException(ErrorMessage.WITHIN_INT_RANGE.getMessage());
            }
        }
    }

    public static void enterBonusNumberValidate(String input) {
        readIntOnly(input);
    }

    private static void readIntOnly(String input) {
        if ( !input.matches("[0-9]*") ) {
            throw new IllegalArgumentException(ErrorMessage.NATURAL_NUMBERS_ONLY.getMessage());
        }
        BigInteger inputAmount = new BigInteger(input);
        if ( inputAmount.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(ErrorMessage.WITHIN_INT_RANGE.getMessage());
        }
    }
}
