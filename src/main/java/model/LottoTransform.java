package model;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoTransform {
    private static final int LOTTO_PRICE = 1000;
    private static List<List<Integer>> lottoNumbers;
    private static List<Integer> winningNumbers;

    public LottoTransform(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers) {
        LottoTransform.lottoNumbers = lottoNumbers;
        LottoTransform.winningNumbers = winningNumbers;
    }

    public void inputToWinningNumbers(String input) {
        List<Integer> sortedWinningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
        winningNumbers.clear();
        winningNumbers.addAll(sortedWinningNumbers);
    }

    public int getLottoCount(String input) {
        int lottoPrice = Integer.parseInt(input);
        //검증 추가 필요
        return lottoPrice/LOTTO_PRICE;
    }

    public void createLottoNumbers(int lottoCount) {
        lottoNumbers.clear();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(createRandomNumbers());
        }
    }

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList();
    }



}
