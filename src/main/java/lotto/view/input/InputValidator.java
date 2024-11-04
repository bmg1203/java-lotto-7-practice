package lotto.view.input;

import static lotto.config.LottoConfig.PRICE;

import lotto.config.ErrorMessage;

public class InputValidator {
    //구입 금액 입력 시 정해진 형식이 아니거나 1000으로 나누어 떠어지지 않을 시 에러 발생
    public static int validatePurchaseAmount(String input){
        try{
            int amount = Integer.parseInt(input);
            if(amount < PRICE || amount % PRICE != 0){
                //입력 금액이 정수로 들어왔지만 1000보다 작거나 나누어 떨어지지 않을 때 에러 발생
                throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            }
            return amount;
        }catch (NumberFormatException e){ //입력 금액이 정수로 들어오지 않았을 때
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    //들어온 문자열이 정수형으로 변환되는지 확인해주는 메소드
    public static int validateNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateContainBlank(String input){
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CONTAIN_BLANK.getMessage());
        }
    }
}
