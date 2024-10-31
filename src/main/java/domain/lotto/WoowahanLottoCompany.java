package domain.lotto;

import domain.consumer.Consumer;

public class WoowahanLottoCompany {
    private final LottoMachin lottoMachin;
    //회사는 여러개일까 한 개일까?
    public WoowahanLottoCompany() {
        lottoMachin = new LottoMachin();
    }

    public void enterForLottoPurchase(Consumer consumer) {
        lottoMachin.sellTo(consumer);
        lottoMachin.printLottoInfo(consumer);
        // 로또 머신이 당첨 번호를 입력받는다.
    }
    /**
     * 우아한 로또 회사는 로또 머신을 가지고 있으며 여러 대일 수 있다.
     * 우아한 로또 회사의 기계는 로또의 당첨 여부를 확인해 줄 수 있다
     * 소비자의 로또 수익률을 계산을 해줄 수 있는 기계가 있다.
     */
}
