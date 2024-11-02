package lotto.service;

import lotto.collection.Lotto;
import lotto.collection.LottoTickets;
import lotto.domain.LottoResult;
import lotto.domain.user.User;
import lotto.enums.LottoConstant;
import lotto.view.OutputView;

import static lotto.view.OutputView.WINNING_STATISTICS;

public class UserWinningResultService {
    // 싱글톤 패턴
    private static final UserWinningResultService instance = new UserWinningResultService();
    private final UserService userService = UserService.getInstance();

    private UserWinningResultService() {

    }

    public static UserWinningResultService getInstance() {
        return instance;
    }

    public void getWinningResult(LottoResult lottoResult, int userId) {
        OutputView.newLine();
        OutputView.printMessage(WINNING_STATISTICS);
        generateStatistics(lottoResult,userId);
    }

    private void generateStatistics(LottoResult lottoResult, int userId) {
        int[][] lottoMatchCount = countMatchWinningNumber(lottoResult,userId);
        for (int match = 3; match <= LottoConstant.COUNT.getValue(); match++) {
            OutputView.printWinningResult(match, lottoMatchCount);
        }
    }

    //TODO: 하드 코딩 같아서 리팩토링 해야함
    private int[][] countMatchWinningNumber(LottoResult lottoResult, int userId) {
        int[][] resultTable = new int[LottoConstant.COUNT.getValue()+1][2];

        User user = userService.findById(userId);
        LottoTickets lottoTickets = user.getLottoTickets();

        for (Lotto lotto : lottoTickets.getTickets()) {
            int matchCount = lotto.countMatchNumberWithWinningNumber(lottoResult.getWinningNumbers());
            if (matchCount == 5 && lotto.isBonusNumberIncludeInWinningNumbers(lottoResult.getBonusNumber())) {
                resultTable[matchCount][1]++;
            }
            resultTable[matchCount][0]++;
        }

        return resultTable;
    }

}
