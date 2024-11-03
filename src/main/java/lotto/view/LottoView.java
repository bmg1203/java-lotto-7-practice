package lotto.view;

import static lotto.model.Lotto.MAX_RANGE;
import static lotto.model.Lotto.MAX_SIZE;
import static lotto.model.Lotto.MIN_RANGE;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class LottoView {
    private static final String WINNING_DELIMITER = ",";

    public BigDecimal inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String str = Console.readLine();
        return new BigDecimal(convertStringToInt(str));
    }

    private int convertStringToInt(String str) {
        validateToInt(str);
        return Integer.parseInt(str);
    }

    private void validateToInt(String str) {
        if (StringUtils.isBlank(str) || !str.codePoints().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 가능합니다.");
        }
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        String[] winningNumberSplit = winningNumber.split(WINNING_DELIMITER);
        validateSize(winningNumberSplit);
        System.out.println();
        return winningNumberToList(winningNumberSplit);
    }

    private List<Integer> winningNumberToList(String[] winningNumberSplit) {
        return Arrays.stream(winningNumberSplit)
                .map(str -> {
                    int num = convertStringToInt(str);
                    validateRange(num);
                    return num;
                })
                .toList();
    }

    private void validateSize(String[] split) {
        if (split.length != MAX_SIZE) {
            throw new IllegalArgumentException("담청 번호는 6자리 입니다.");
        }
    }

    private void validateRange(int num) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException("번호는 1에서 45 사이여야 합니다.");
        }
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        int num = convertStringToInt(bonusNumber);
        validateRange(num);
        return num;
    }

    public void printWinningTrace(String winningTrace) {
        System.out.println("당첨 통계\n---");
        System.out.println(winningTrace);
    }

    public void printWinningRate(String winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }
}
