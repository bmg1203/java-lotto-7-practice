package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import lotto.EnumManagement.LottoEnum;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers.sort(Integer::compareTo); // 오름차순 정렬
        this.numbers = numbers;
    }

    public void start(OutputView outputView, InputView inputView) {
        List<Integer> lottoMatchTable = lottoNumberCheck(outputView.getBoughtLottoNumbers(), inputView.getBonusNumber());
        outputView.lottoWinOutput(lottoMatchTable);
        double lottoReturnRate = calLottoReturnRate(lottoMatchTable, inputView.getLottoPurchase());
        outputView.lottoReturnRateOutput(lottoReturnRate);
    }

    public List<Integer> makeLottoWinPrice(List<Integer> lottoWinPrice) {
        int size = 0;
        for (LottoEnum lottoPrice : LottoEnum.values()) {
            if (size < LottoEnum.LOTTO_WINNING_SIZE.getNumber())
                lottoWinPrice.add(lottoPrice.getNumber());
            size++;
        }
        return lottoWinPrice;
    }

    public double calLottoReturnRate(List<Integer> lottoMatchTable, int lottoPurchase) {
        long totalLottoWinPrice = 0;
        List<Integer> lottoWinPrice = new ArrayList<>();
        lottoWinPrice = makeLottoWinPrice(lottoWinPrice);
        for (int i = 0; i < lottoMatchTable.size(); i++) {
            totalLottoWinPrice += (long) lottoMatchTable.get(i) * lottoWinPrice.get(i);
        }

        return (double) totalLottoWinPrice / lottoPurchase * LottoEnum.MULTI_100.getNumber();
    }

    public List<Integer> pushNumberTable(List<Integer> equalNumberTable, int equalNumberCount, boolean bonusNumber) {
        int[] countToIndex = {0, 0, 0, 0, 1, 2, 4}; // 같은 숫자가 3개 이상 부터 로또 당첨이어서 해당 값을 활용해서 임의로 리스트의 INDEX 이동하기 위해 사용

        if (equalNumberCount == LottoEnum.EQUAL_LOTTO_NUMBER_5.getNumber() && bonusNumber) {
            equalNumberTable.set(LottoEnum.NUMBER_TABLE_INDEX_3.getNumber(), equalNumberTable.get(LottoEnum.NUMBER_TABLE_INDEX_3.getNumber()) + LottoEnum.LOTTO_WINNING.getNumber());
            return equalNumberTable;
        }
        //발행한 로또에 3개부터 6개까지 같은 숫자가 있으면 equalNumberTable에 각 List의 Index에 맞게 1씩 증가 시킨다.(5등 ~ 1등 당첨된 로또의 개수)
        for (int i = LottoEnum.NUMBER_TABLE_INDEX_3.getNumber(); i <= LottoEnum.NUMBER_TABLE_INDEX_6.getNumber(); i++) {
            if (equalNumberCount == i) {
                equalNumberTable.set(countToIndex[i], equalNumberTable.get(countToIndex[i]) + LottoEnum.LOTTO_WINNING.getNumber());
                break;
            }
        }

        return equalNumberTable;
    }

    public List<Integer> lottoNumberCheck(List<List<Integer>> boughtLottoNumbers, int bonusNumber) {
        List<Integer> equalNumberTable = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (List<Integer> boughtLottoNumber : boughtLottoNumbers) {
            int equalNumberCount = 0;
            boolean equalBonusNumber = false;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.contains(boughtLottoNumber.get(i))) {
                    equalNumberCount++;
                }
                if (boughtLottoNumber.get(i).equals(bonusNumber)) {
                    equalBonusNumber = true;
                }
            }
            if (LottoEnum.EQUAL_NUMBER_COUNT_3.getNumber() <= equalNumberCount)
                equalNumberTable = pushNumberTable(equalNumberTable, equalNumberCount, equalBonusNumber);
        }
        return equalNumberTable;
    }
}


