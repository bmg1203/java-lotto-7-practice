package lotto.util;

import static lotto.util.LottoConstants.*;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {
    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 허용되지 않습니다.");
        } else if (!isValidAmountInThousand(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 구매가 가능합니다.");
        }
    }

    public static void validateLottoNumbers (List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        } else if (!isValidWinningNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
        } else if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (bonusNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 음수가 허용되지 않습니다.");
        } else if (!isValidBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        } else if (isInWinningNumbers(bonusNumber, numbers)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private static boolean isValidAmountInThousand(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE == 0;
    }

    private static boolean hasDuplicates(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    private static boolean isValidWinningNumber(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
    }

    private static boolean isValidBonusNumber(int bonusNumber) {
        return bonusNumber >= MIN_LOTTO_NUMBER && bonusNumber <= MAX_LOTTO_NUMBER;
    }

    private static boolean isInWinningNumbers(int bonusNumber, List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
