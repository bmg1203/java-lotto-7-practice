package lotto.view;

public enum InputMessage {

    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

