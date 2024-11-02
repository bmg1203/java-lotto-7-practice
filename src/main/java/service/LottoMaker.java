package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.LottoTransform;
import model.LottoValidation;

public class LottoMaker {
    private static final List<List<Integer>> lottoNumbers = new ArrayList<>();
    private static final List<Integer> winningNumbers = new ArrayList<>();
    private static final List<Integer> winningResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    private static final int ONE_LOTTO_PRICE = 1000;
    private static int purchaseAmount = 0;
    private static int bonusNumber = 0;

    private final LottoTransform lottoTransform = new LottoTransform(lottoNumbers, winningNumbers);
    private final LottoValidation lottoValidation = new LottoValidation(winningNumbers, winningResult);

    public int getLottoCount(String amount) {
        purchaseAmount = lottoTransform.getLottoCount(amount);
        return purchaseAmount;
    }

    public List<List<Integer>> createLotto() {
        lottoTransform.createLottoNumbers(purchaseAmount);
        return lottoNumbers;
    }

    public void setWinningNumbers(String input) {
        lottoTransform.inputToWinningNumbers(input);
    }

    public void setBonusNumber(String input) { //model에서 값 변환 전 예외처리 위한 래핑
        bonusNumber = lottoTransform.inputToBonusNumber(input);
    }

    public List<Integer> getWinningResults() {
        for (List<Integer> lottoNumber : lottoNumbers) {
            lottoValidation.updateWinningResult(lottoNumber, bonusNumber);
        }
        return winningResult;
    }

    public double getProfitRate() {
        return lottoValidation.calculateProfitRate(purchaseAmount*ONE_LOTTO_PRICE);
    }
}
