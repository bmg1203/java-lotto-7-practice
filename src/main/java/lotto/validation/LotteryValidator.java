package lotto.validation;

import static lotto.constant.LotteryConstant.DEFAULT_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class LotteryValidator {

    public boolean validateInputPurchaseAmount(final String inputPurchaseAmount) {
        try {
            allowParseIntPurchaseAmount(inputPurchaseAmount);

            final int lottoPurchaseAmount = Integer.parseInt(inputPurchaseAmount);
            allowUnitMoney(lottoPurchaseAmount);

        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    // 사용자가 입력한 로또 구입 금액이 정수인지 판단한다.
    public void allowParseIntPurchaseAmount(final String inputPurchaseAmount) {
        try {
            Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(DEFAULT_ERROR_MESSAGE + " 올바른 금액을 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    // 사용자가 입력한 금액의 단위가 1,000원 단위인지 판단한다.
    public void allowUnitMoney(final int inputPurchaseAmount) {
        try {
            if (inputPurchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(DEFAULT_ERROR_MESSAGE + " 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 로또 숫자 입력이 올바른지 판단한다.
    public boolean validateInputLottoNumbers(final String inputLottoNumbers) {
        try {
            List<Integer> numbers = new ArrayList<>();
            for (final String number : inputLottoNumbers.split(",")) {
                numbers.add(Integer.parseInt(number.trim()));
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 정수여야 합니다.");
        }
    }

    // 로또 보너스 숫자 입력이 올바른지 판단한다.
    public boolean validateInputLottoBonusNumber(final String inputLottoBonusNumber) {
        try {
            Integer.parseInt(inputLottoBonusNumber);
        } catch (NumberFormatException e) {
            System.out.println(DEFAULT_ERROR_MESSAGE + "보너스 로또 번호는 정수여야 합니다.");
            return true;
        }
        return true;
    }
}
