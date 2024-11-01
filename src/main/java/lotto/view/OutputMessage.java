package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import lotto.constant.Rank;

public enum OutputMessage {
    INPUT_MONEY("구입금액을 입력해 주세요.%n"),
    BUY_LOTTO_TICKETS("%n%d개를 구매했습니다.%n"),
    LOTTO_NUMBERS("[%s]%n"),
    INPUT_WINNING_NUMBERS("%n당첨 번호를 입력해 주세요.%n"),
    INPUT_BONUS_NUMBER("%n보너스 번호를 입력해 주세요.%n"),
    INIT_RESULT("%n당첨 통계%n---%n"),
    RANK_RESULT("%d개 일치 (%s원) - %d개%n"),
    RANK_RESULT_SECOND("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n"),
    RETURN_RESULT("총 수익률은 %.1f%%입니다."),
    EXCEPTION("%n[ERROR] %s%n%n"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(message);
    }

    public String getMessage(int content) {
        return String.format(message, content);
    }

    public String getMessage(double content) {
        return String.format(message, content);
    }

    public String getMessage(String content) {
        return String.format(message, content);
    }

    public String getMessage(List<Integer> lottoNumbers) {
        if (equals(LOTTO_NUMBERS)) {
            return String.format(message,
                lottoNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "))
            );
        }
        return String.format(message);
    }

    public String getMessage(Rank rank, int rankCount) {
        if (equals(RANK_RESULT)) {
            if (rank.equals(Rank.SECOND)) {
                return String.format(
                    RANK_RESULT_SECOND.message,
                    rank.getMatchCount(),
                    new DecimalFormat("###,###").format(rank.getPrice()),
                    rankCount
                );
            }
            return String.format(
                message,
                rank.getMatchCount(),
                new DecimalFormat("###,###").format(rank.getPrice()),
                rankCount
            );
        }
        return String.format(message);
    }
}
