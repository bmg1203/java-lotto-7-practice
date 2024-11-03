package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoWinningNumber;
import lotto.service.lottoImpl.DataServiceImpl;

import java.util.List;

public class DataService implements DataServiceImpl {
    private RandomNumberService randomNumberService;

    @Override
    public LottoWinningNumber createWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoWinningNumber(winningNumbers, bonusNumber);
    }

    @Override
    public List<Lotto> createLottos(int tickets) {
        return randomNumberService.createRandomNumber(tickets);
    }

    @Override
    public List<Integer> readWinningNumber(LottoWinningNumber winningNumber) {
        return winningNumber.getLottoWinningNumber();
    }

    @Override
    public int readBonusNumber(LottoWinningNumber winningNumber) {
        return winningNumber.getBonusNumber();
    }
}
