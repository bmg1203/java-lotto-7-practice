package lotto.purchase;

import java.util.List;

public record LottoReceipt(int payment, List<MyLotto> myLotteries) {

    private static final int LOTTO_PRICE = 1000;
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void printTotalLottoNumber() {
        System.out.println();
        System.out.println((payment / LOTTO_PRICE) + PURCHASE_MESSAGE);
    }

    public void printAllLotteries() {
        for (MyLotto lotto : myLotteries) {
            System.out.println(lotto.numbers());
        }
    }
}
