package lotto.utils;

public final class StringValidator {
    
    private StringValidator() {}
    
    public static boolean isEmpty(String lineToValidate) {
        return lineToValidate.isEmpty();
    }
    
    public static boolean hasBlank(String lineToValidate) {
        return lineToValidate.contains(" ");
    }
    
    public static boolean hasNotDigits(String lineToValidate) {
        return !lineToValidate.matches("^[0-9]*$");
    }

    public static boolean isOutOfRangeLottoNumber(String lineToValidate) {
        int numberToValidate;
        try {
            numberToValidate = Integer.parseInt(lineToValidate);
            return (numberToValidate < Constants.MIN_LOTTO_NUMBER
                    || numberToValidate > Constants.MAX_LOTTO_NUMBER);
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
