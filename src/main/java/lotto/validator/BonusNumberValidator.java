package lotto.validator;

import lotto.constant.ErrorConstants;

public class BonusNumberValidator implements Validator{

    private static final String SPACE = " ";
    private static final String REGEX = "^([1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5])";
    @Override
    public void validate(String input){
        checkIfNull(input);
        checkIfEmpty(input);
        checkIfMatchesRegex(input);
    }

    private void checkIfNull(String input){
        if(input == null){
            throw new IllegalArgumentException(ErrorConstants.EMPTY_VALUE_NOT_ALLOWED.getMessage());
        }
    }
    private void checkIfEmpty(String input){

        if(input.isEmpty() || input.equals(SPACE)){
            throw new IllegalArgumentException(ErrorConstants.EMPTY_VALUE_NOT_ALLOWED.getMessage());
        }
    }

    private void checkIfMatchesRegex(String input){
        if(!input.matches(REGEX)){
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

}
