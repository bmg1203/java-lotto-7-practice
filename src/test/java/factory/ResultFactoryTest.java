package factory;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import model.BonusNumber;
import model.LottoCollection;
import model.WinningLottoNum;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultFactoryTest {

    private LottoCollection lottoCollection;

    @BeforeEach
    public void testInit() {
        lottoCollection = new LottoCollection();
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(nums);
        lottoCollection.add(lotto);
    }

    @Test
    void 당첨_테스트_1등() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Integer, Integer> result = resultFactory.getResult();

        assertThat(result.get(1)).isEqualTo(1);
    }

    @Test
    void 당첨_테스트_2등() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 7);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Integer, Integer> result = resultFactory.getResult();

        assertThat(result.get(2)).isEqualTo(1);
    }

    @Test
    void 당첨_테스트_3등() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Integer, Integer> result = resultFactory.getResult();

        assertThat(result.get(3)).isEqualTo(1);
    }

    @Test
    void 당첨_테스트_4등() {
        List<Integer> nums = List.of(1, 2, 11, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Integer, Integer> result = resultFactory.getResult();

        assertThat(result.get(4)).isEqualTo(1);
    }

    @Test
    void 당첨_테스트_5등() {
        List<Integer> nums = List.of(45, 2, 11, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Integer, Integer> result = resultFactory.getResult();

        assertThat(result.get(5)).isEqualTo(1);
    }

    @Test
    void 미당첨_테스트() {
        List<Integer> nums = List.of(45, 9, 11, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Integer, Integer> result = resultFactory.getResult();

        assertThat(result.get(0)).isEqualTo(1);
    }
}
