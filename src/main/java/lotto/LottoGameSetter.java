package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGameSetter {

    public LottoGame set() {

        System.out.println("구입금액을 입력해 주세요.");
        Integer totalPrice = Integer.parseInt(readLine());
        if(totalPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000의 배수인 정수를 입력해야 합니다.");
        }

        Integer totalLottoCount = totalPrice / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < totalLottoCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
        }

        StringBuilder lottoPurchaseResult = new StringBuilder();
        lottoPurchaseResult.append("\n").append(totalLottoCount).append("개를 구매했습니다.\n");
        lottos.stream()
                .forEach(lotto -> {
                    lottoPurchaseResult.append("[");
                    lottoPurchaseResult.append(lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", ")));
                    lottoPurchaseResult.append("]\n");
                });

        System.out.println(lottoPurchaseResult);


        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        String[] inputNumbers = input.split(",");

        Set<Integer> winningNumbers = Arrays.stream(inputNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .filter(value -> {
                    if(value > 45 || value < 1) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되지 않는 1~45 사이의 6가지 수여야 합니다.");
                    }
                    return true;
                })
                .collect(Collectors.toSet());

        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되지 않는 1~45 사이의 6가지 수여야 합니다.");
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumberInput = readLine();
        Integer bonusNumber = Integer.parseInt(bonusNumberInput);
        if(bonusNumber > 45 || bonusNumber <1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");
        }
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");
        }

        return LottoGame.of(totalPrice, lottos, winningNumbers, bonusNumber);
    }
}
