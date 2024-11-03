package lotto.parser;

import static lotto.model.Constants.MULTIPLES_OF_LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InputException;
import lotto.message.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.validator.InputValidator;

public class InputParser {

    // 구매 금액을 구매 수량으로 파싱
    public static int parsePurchaseAmount(String input) {
        int purchaseAmount;
        InputValidator.isPurchaseAmountBlank(input);

        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessage.UNAVAILABLE_TYPE_PURCHASE_AMOUNT.getMessage());
        }

        InputValidator.isMultiplesOfThousand(purchaseAmount);

        return purchaseAmount / MULTIPLES_OF_LOTTO_PRICE;
    }

    // 당첨번호(String)를 WinningLotto로 파싱
    public static WinningLotto parseWinningLotto(String winningNumbers, int bonusNumber) {
        // TODO 당첨번호가 숫자인지 확인 + 당첨번호가 null인지 체크
        List<Integer> winningNumberList = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        Lotto winningLotto = new Lotto(winningNumberList);

        return new WinningLotto(winningLotto, bonusNumber);
    }
}
