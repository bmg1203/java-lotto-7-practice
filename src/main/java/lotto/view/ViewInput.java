package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ViewInput {
    public static final String INITIAL_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_AMOUNT_COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String RECEIVE_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해주세요";
    public static final String RECEIVE_LUCKY_NUMBER_MESSAGE = "보너스 번호를 입력해주세요";
    public static final String INPUT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String INPUT_NEGATIVE_VALUE_ERROR_MESSAGE = "[ERROR] 구입 금액은 음수가 될 수 없습니다.";
    public static final String WINNING_NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 6개 이어야 합니다.";
    public static final String WINNING_NUMBER_VALUE_ERROR = "[ERROR] 당첨 번호는 1~45사이의 숫자이어야 합니다.";
    public static final String LUCK_NUMBER_VALUE_ERROR = "[ERROR] 행운의 순자는 1~45사이의 숫자이어야 합니다.";
    public static final String WINNING_NUMBER_DUPLICATE_ERROR ="[ERROR] 행운의 숫자와 당첨 번호는 중복될 수 없습니다.";

    public static List<Integer> winningNumberList = new ArrayList<>();

    public int receivePurchaseAmount(){
        System.out.println(INITIAL_MESSAGE);
        String purchaseAmount = Console.readLine();
        validatorPurchaseAmount(Integer.parseInt(purchaseAmount));
        printPurchaseAmount(Integer.parseInt(purchaseAmount));
        return Integer.parseInt(purchaseAmount)/1000;
    }

    public List<Integer> receiveWinningNumber(){
        System.out.println(RECEIVE_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        String[] winningNumberArray = winningNumber.split(",");
        for (String s : winningNumberArray) {
            winningNumberList.add(Integer.parseInt(s.trim()));
        }
        validWinningNumber(winningNumberList);
        return winningNumberList;
    }

    public int receiveLuckyNumber(){
        System.out.println(RECEIVE_LUCKY_NUMBER_MESSAGE);
        String luckyNumber = Console.readLine();
        validatorLuckyNumber(Integer.parseInt(luckyNumber),winningNumberList);
        return Integer.parseInt(luckyNumber.trim());
    }

    private void printPurchaseAmount(int purchaseAmount){
        int purchaseAmountCount = purchaseAmount / 1000;
        System.out.println(purchaseAmountCount + PURCHASE_AMOUNT_COUNT_MESSAGE);
    }

    private void validatorPurchaseAmount(int purchaseAmount){
        if(purchaseAmount < 0){
            throw new IllegalArgumentException(INPUT_NEGATIVE_VALUE_ERROR_MESSAGE);
        }
        if(purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private void validWinningNumber(List<Integer> winningNumberList){
        if(winningNumberList.size() != 6){
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROR);
        }
        for(Integer number : winningNumberList){
            if(number < 0 || number > 45){
                throw new IllegalArgumentException(WINNING_NUMBER_VALUE_ERROR);
            }
        }
    }

    private void validatorLuckyNumber(int luckyNumber, List<Integer> winningNumberList){
        if(luckyNumber < 0 || luckyNumber > 45){
            throw new IllegalArgumentException(LUCK_NUMBER_VALUE_ERROR);
        }
        List<Integer> winningNumberListCheck = winningNumberList;
        for(Integer number : winningNumberListCheck){
            if(luckyNumber == number){
                throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_ERROR);
            }
        }
    }

}
