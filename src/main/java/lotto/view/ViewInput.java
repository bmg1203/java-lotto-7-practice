package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class ViewInput {
    public static final String INITIAL_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String PURCHASE_AMOUNT_COUNT_MESSAGE = "개를 구매했습니다.";

    public int receivePurchaseAmount(){
        System.out.println(INITIAL_MESSAGE);
        String purchaseAmount = Console.readLine();
        validatorPurchaseAmount(Integer.parseInt(purchaseAmount));
        printPurchaseAmount(Integer.parseInt(purchaseAmount));
        return Integer.parseInt(purchaseAmount);
    }

    public void printPurchaseAmount(int purchaseAmount){
        int purchaseAmountCount = purchaseAmount / 1000;
        System.out.println(purchaseAmountCount + PURCHASE_AMOUNT_COUNT_MESSAGE);
    }

    private void validatorPurchaseAmount(int purchaseAmount){
        if(purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
