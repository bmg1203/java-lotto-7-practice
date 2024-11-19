package lotto.constants;

public enum InputPrompts {

    PURCHASE_MONEY_INPUT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요.");

    private final String prompt;

    InputPrompts(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
