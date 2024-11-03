package lotto;

import java.util.List;

public final class InputValidator {

    private InputValidator() {
    }

    public static void validatePurchaseAmountIsZero(final int purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원일 수 없습니다.");
        }
    }

    public static void validatePurchaseAmountUnit(final int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위이어야 합니다.");
        }
    }

    public static void validateWinningLottoNumbersCount(final List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 숫자는 6개이어야 합니다.");
        }
    }

    public static void validateWinningLottoNumbersInRange(final List<Integer> winningLottoNumbers) {
        winningLottoNumbers.forEach(
                winningLottoNumber -> {
                    if (!validateInLottoNumberRange(winningLottoNumber)) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 숫자이어야 합니다.");
                    }
                });
    }

    private static boolean validateInLottoNumberRange(final int winningLottoNumber) {
        return winningLottoNumber >= 1 && winningLottoNumber <= 45;
    }
}
