package lotto;

import java.util.List;

public interface ApplicationView {

    int requestMoney();

    void printPurchasedLotto(List<String> lottos);
}
