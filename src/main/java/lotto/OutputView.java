package lotto;

import java.util.Iterator;

public class OutputView {
    private final String LOTTO_NUMBER_DELIMITER = ", ";
    private final String OPEN_BRACKET = "[";
    private final String CLOSED_BRACKET = "]";

    public void displayLottoCount(Lottos lottos) {
        System.out.println("\n" + lottos.getLottoCount() + "개를 구매했습니다.");
    }

    public void displayLottoNumbers(Lottos lottos) {
        Iterator<Lotto> totalLottos = lottos.getLottos();

        while (totalLottos.hasNext()) {
            Lotto lotto = totalLottos.next();
            displayLotto(lotto);
        }
    }

    private void displayLotto(Lotto lotto) {
        System.out.print(OPEN_BRACKET);
        displayNumbers(lotto.getNumbers());
        System.out.println(CLOSED_BRACKET);
    }

    private void displayNumbers(Iterator<Integer> numbers) {
        System.out.print(numbers.next());

        while (numbers.hasNext()) {
            System.out.print(LOTTO_NUMBER_DELIMITER);
            System.out.print(numbers.next());
        }
    }
}
