package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    public int priceInput() {
        while(true) {
            try {
                int price = Integer.parseInt(Console.readLine());
                priceInputValidator(price);
                return price;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void priceInputValidator(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위만 가능합니다.");
        }
    }

    public List<Integer> winningNumbersInput(){
        while(true){
            try{
                List<Integer> winningNumbers = new ArrayList<>();
                List<String> numbersInString = Arrays.asList(Console.readLine().split(,));
                for (String number : numbersInString){
                    winningNumbers.add(Integer.parseInt(number));
                }
                winningNumbersInputValidator(winningNumbers);
                return winningNumbers;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void winningNumbersInputValidator(List<Integer> winningNumbers){
        List<Integer> check = new ArrayList<>();
        for (int number : winningNumbers){
            if (check.contains(number)){
                throw new IllegalArgumentException("[ERROR] 당첨번호에 중복된 숫자가 존재합니다.")
            }
            check.add(number);
        }
    }

}
