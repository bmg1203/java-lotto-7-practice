package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class LottoController {
    public void run() {
        // 로또 구입 금액 입력 받기
        int inputCash = LottoView.getInputCash();

        // 1000 단위, 숫자 여부 검증 필요
        int lottoCount = inputCash / 1000;

        // 로또 생성 과정
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        // 발행한 로또 수량 및 번호 출력
        LottoView.printLottos(lottoCount, lottos);

        // 당첨 번호 입력 받기
        List<Integer> winningNumbers = LottoView.getWinningNumbers();

        // 보너스 번호 입력 받기
        Integer bonusNumber = LottoView.getBonusNumber();

        // 당첨 여부 확인

        // 등수 계산
        Map<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);
        int totalPrize = 0;

        // 각 등수의 개수를 0으로 초기화
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Set<Integer> matchedNumbers = new HashSet<>(winningNumbers);
            Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());

            boolean isBonusMatched = lottoNumbers.contains(bonusNumber);
            matchedNumbers.retainAll(lottoNumbers);

            int matchCount = matchedNumbers.size();
            LottoRank rank = LottoRank.calculateRank(matchCount, isBonusMatched);

            if (rank != null) {
                rankCount.put(rank, rankCount.get(rank) + 1);
                totalPrize += rank.getPrize();
            }
        }

        // 당첨 내역 출력
        LottoView.printLottoResult(rankCount);

        // 수익률 계산 및 출력
        LottoView.printReturnRate(totalPrize, inputCash);
    }
}
