package observerTest;

import java.util.List;
import lotto.Lotto;
import lotto.PurchasedLotto;
import lottoFactory.LottoFactory;
import observer.Observer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rank.LottoRank;
import repository.PurchasedLottoRepository;
import repository.WinningNumberRepository;
import utils.InputUtils;
import winningLottoNumber.BonusNumber;
import winningLottoNumber.WinningLottoNumber;

public class ObserverTest {

    private WinningNumberRepository winningNumberRepository;
    private PurchasedLottoRepository purchasedLottoRepository;
    private WinningLottoNumber winningLottoNumber;
    PurchasedLotto purchasedLotto1;
    PurchasedLotto purchasedLotto2;
    PurchasedLotto purchasedLotto3;
    PurchasedLotto purchasedLotto4;
    PurchasedLotto purchasedLotto5;
    PurchasedLotto purchasedLotto6;
    Lotto winningLotto;
    @BeforeEach
    void beforeEach(){
        List<Integer> fail = List.of(1,2,3,4,5,6);
        List<Integer> fifth = List.of(3,5,37,4,6,7);
        List<Integer> fourth = List.of(3,5,37,38,6,7);
        List<Integer> third = List.of(3,5,37,38,44,2);
        List<Integer> second = List.of(3,5,37,38,44,1);
        List<Integer> first = List.of(3,5,37,38,44,45);

        List<Integer> numbersWinning = List.of(3,5,37,38,44,45);
        Lotto lotto6 = new Lotto(fail);
        Lotto lotto5 = new Lotto(fifth);
        Lotto lotto4 = new Lotto(fourth);
        Lotto lotto3 = new Lotto(third);
        Lotto lotto2 = new Lotto(second);
        Lotto lotto1 = new Lotto(first);
        winningLotto = new Lotto(numbersWinning);
        purchasedLotto1 =PurchasedLotto.createPurchasedLotto(lotto1);
        purchasedLotto2 =PurchasedLotto.createPurchasedLotto(lotto2);
        purchasedLotto3 =PurchasedLotto.createPurchasedLotto(lotto3);
        purchasedLotto4 =PurchasedLotto.createPurchasedLotto(lotto4);
        purchasedLotto5 =PurchasedLotto.createPurchasedLotto(lotto5);
        purchasedLotto6 =PurchasedLotto.createPurchasedLotto(lotto6);
        winningNumberRepository=new WinningNumberRepository();
        purchasedLottoRepository=new PurchasedLottoRepository();

    }

    @Test
    void 옵저버_테스트_WinningLottoNumber_확정전에는_rank_는_null(){
        List<Observer> myAllLotto = purchasedLottoRepository.findMyAllLotto();
        for (Observer allLotto : myAllLotto) {
            LottoRank rank = ((PurchasedLotto) allLotto).getRank();
            Assertions.assertEquals(null,rank);
        }

    }

    @Test
    void 옵저버_테스트_WinningLottoNumber_확정후_rank_정해짐(){
        BonusNumber bonusNumber=BonusNumber.createBonusNumber("1");
        winningLottoNumber=WinningLottoNumber.createWinningLotto(winningLotto,bonusNumber);

        List<Observer> myAllLotto = purchasedLottoRepository.findMyAllLotto();

        for (Observer allLotto : myAllLotto) {
            LottoRank rank = ((PurchasedLotto) allLotto).getRank();
            LottoRank[] lottoRanks = LottoRank.values();
            for (LottoRank lottoRank : lottoRanks) {
                Assertions.assertEquals(lottoRank,rank);
            }

        }

    }


}
