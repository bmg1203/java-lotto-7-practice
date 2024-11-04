package lotto.view.input;

import static lotto.view.exception.ErrorMessage.numberCommerForat;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static final String purchaseAmountConsole = "구입금액을 입력해 주세요.";
    public static final String getWinNumbers = "당첨 번호를 입력해 주세요.";

    public String purchaseAmount(){
        return Console.readLine();
    }

    public List<Integer> getWinNumbers(){
        String inputNumber = Console.readLine();

        return getNumbersSplit(inputNumber);
    }

    /*
     * 당첨 번호의 숫자를 입력 받은 후 ,로 나눠주는 메서드
     */
    private List<Integer> getNumbersSplit(String inputNumber){
        List<Integer> numbers = new ArrayList<>();

        try{
            for (String number : inputNumber.split(",")) {
                numbers.add(Integer.parseInt(number.trim()));
            }
        }catch (NumberFormatException n){
            throw new NumberFormatException(numberCommerForat);
        }

        return numbers;
    }


}
