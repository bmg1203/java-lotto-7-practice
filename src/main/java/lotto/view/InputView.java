package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.contants.value.LottoValue;
import lotto.contants.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int payAmount() {
        String purchasePrice = Console.readLine();
        int priceValue = Integer.parseInt(purchasePrice);
        validatePurchasePrice(priceValue);

        return priceValue;
    }

    public List<Integer> prizeNumbers() {
        String prizeNumbers = Console.readLine();
        String[] splitPrizeNumbers = prizeNumbers.split(",");

        return convertToPrizeNumbers(splitPrizeNumbers);
    }

    public int bonusNumber() {
        String bonusNumber = Console.readLine();
        validateLottoNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    public List<Integer> convertToPrizeNumbers(String[] splitPrizeNumbers) {
        List<Integer> winningNumberValues = new ArrayList<>();
        for (String str : splitPrizeNumbers) {
            validateLottoNumber(str);
            winningNumberValues.add(Integer.parseInt(str));
        }

        return winningNumberValues;
    }

    public void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % LottoValue.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE);
        }
    }

    public void validateLottoNumber(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.SPILT_EMPTY);
        }
        if (Integer.parseInt(str) < LottoValue.MIN_LOTTO_NUM && Integer.parseInt(str) > LottoValue.MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE);
        }
    }
}
