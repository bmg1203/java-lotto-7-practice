package lotto.constants;

public enum OutputPrompts {

    PURCHASE_COUNT_OUTPUT("%d개를 구매했습니다."),
    WINNING_STATISTICS_HEADER_OUTPUT("당첨 통계\n---"),
    FIFTH_PLACE_COUNT_OUTPUT("3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE_COUNT_OUTPUT("4개 일치 (50,000원) - %d개"),
    THIRD_PLACE_COUNT_OUTPUT("5개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE_COUNT_OUTPUT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PLACE_COUNT_OUTPUT("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN_OUTPUT("총 수익률은 %s%%입니다.");

    private final String prompt;

    OutputPrompts(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt + "\n";
    }
}
