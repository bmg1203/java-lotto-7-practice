package lotto.result;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.service.ResultService;
import lotto.service.WinningService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    private User user;
    private Result result;
    private Winning winning;
    private Lottos lottos;
    private ResultService resultService;
    private WinningService winningService;

    @BeforeEach
    public void setUp() {
        user = new User();
        result = new Result();
        winning = new Winning();
        winningService = new WinningService(lottos, winning);
        resultService = new ResultService(user, lottos, winning);

        HashSet<Integer> winningSet = new HashSet<>();
        winningSet.add(1);
        winningSet.add(3);
        winningSet.add(4);
        winningSet.add(7);
        winningSet.add(9);

        winning.setHashSet(winningSet);
    }

    @Test
    @DisplayName("당첨 번호 갯수를 확인한다.")
    public void testWinningNumbersCount() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);

        winningService.containsWinningNumber(lottoNumbers);
        int winningCount = resultService.checkWinningNumbersCount(lottoNumbers);

        assertEquals(3, winningCount);
    }

    @Test
    @DisplayName("당첨 번호 갯수가 5개이다.")
    public void testIsWinningNumberFive() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,7,9);

        winningService.containsWinningNumber(lottoNumbers);
        int winningCount = resultService.checkWinningNumbersCount(lottoNumbers);

        assertTrue(resultService.isFiveWinningNumber(winningCount));
    }

    @Test
    @DisplayName("보너스 번호를 확인한다.")
    public void testHashBonusNumber() {
        Lotto lotto = new Lotto(new LinkedList<>(Arrays.asList(1,2,3,4,7,9)));
        winning.setBonusNumber(9);

        int winningCount = resultService.hasBonusNumber(lotto.getNumber(), winning.getBonusNumber());

        assertEquals(50, winningCount);
    }
}
