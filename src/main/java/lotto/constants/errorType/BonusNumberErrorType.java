package lotto.constants.errorType;

public enum BonusNumberErrorType {

    INVALID_BONUS_NUMBER_RANGE("[ERROR] 로또 당첨 번호는 1~45의 숫자만 입력해 주세요."),
    BONUS_NUMBER_NULL_ERROR("[ERROR] 공백은 입력할 수 없습니다. 다시 입력해 주세요."),
    INVALID_BONUS_NUMBER_FORMAT("[ERROR] 지원하지 않는 당첨 번호 형식입니다. 다시 입력해 주세요."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 겹칠 수 없습니다. 다시 입력해 주세요.");

    private final String message;

    BonusNumberErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
