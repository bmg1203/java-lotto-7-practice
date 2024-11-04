package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class OutputView {

    public static void printPurchaseQuantity(final int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottos(final List<Lotto> lottos) {
        lottos.forEach(OutputView::printLotto);
        System.out.println();
    }

    public static void printLotto(final Lotto lotto) {
        String result = lotto.numbers().stream()
                .map(LottoNumber::number)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }
}
