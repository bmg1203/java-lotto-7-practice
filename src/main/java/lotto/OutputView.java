package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final char ARRAY_BEGIN = '[';
    private static final char ARRAY_END = ']';
    private static final String ARRAY_SEPARATOR = ", ";
    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    public void printHowMany(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public void printException(String detailedMessage) {
        System.out.println(EXCEPTION_PREFIX + detailedMessage);
    }

    public void printIssuedLottos(List<Lotto> lottoes) {
        for (Lotto lotto : lottoes) {
            printNumbers(lotto);
        }
        System.out.println();
    }

    private void printNumbers(Lotto lotto) {
        String separatedNumbers = lotto.getNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(ARRAY_SEPARATOR));
        System.out.println(ARRAY_BEGIN + separatedNumbers + ARRAY_END);
    }
}
