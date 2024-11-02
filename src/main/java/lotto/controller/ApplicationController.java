package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Application;
import lotto.model.Lotto;
import lotto.model.LottoPrizeMoney;
import lotto.view.ViewInput;
import lotto.view.ViewOutput;

import java.util.ArrayList;
import java.util.List;

public class ApplicationController {
    private final ViewInput viewInput;
    private final ViewOutput viewOutput;
    private final Lotto lotto;

    public ApplicationController(ViewInput viewInput, ViewOutput viewOutput, Lotto lotto) {
        this.viewInput = viewInput;
        this.viewOutput = viewOutput;
        this.lotto = lotto;
    }


    public void run() {
        int purchaseAmount = viewInput.receivePurchaseAmount();
        int countFirst = 0;
        int countSecond = 0;
        int countThird = 0;
        int countFourth = 0;
        int countFifth = 0;

        List<List<Integer>> lottoNumber = new ArrayList<>();
        List<Integer> lottoNumberList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottoNumberList =  Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumber.add(lottoNumberList);
            lotto.printLottoNumbers(lottoNumberList);
        }


        List<Integer> winningNumber = viewInput.receiveWinningNumber();
        int luckyNumber = viewInput.receiveLuckyNumber();

        for (List<Integer> subList : lottoNumber) {
            if (lotto.judgeWinning(subList, winningNumber, luckyNumber).equals(LottoPrizeMoney.FIRST)) {
                countFirst++;
            }
            if(lotto.judgeWinning(subList, winningNumber, luckyNumber).equals(LottoPrizeMoney.SECOND)) {
                countSecond++;
            }
            if(lotto.judgeWinning(subList, winningNumber, luckyNumber).equals(LottoPrizeMoney.THIRD)) {
                countThird++;
            }
            if(lotto.judgeWinning(subList, winningNumber, luckyNumber).equals(LottoPrizeMoney.FOURTH)) {
                countFourth++;
            }
            if(lotto.judgeWinning(subList, winningNumber, luckyNumber).equals(LottoPrizeMoney.FIFTH)) {
                countFifth++;
            }
        }
        viewOutput.printResult(countFirst, countSecond, countThird, countFourth, countFifth);
        viewOutput.printEarningRateResult(lotto.calculateEarningRate(purchaseAmount, countFirst, countSecond,countThird, countFourth, countFifth));

    }
}
