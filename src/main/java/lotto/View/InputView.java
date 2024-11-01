package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Messages.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";

    public static Integer readPurchaseAmount(){
        int purchasePrice = 0;
        try {
            String rawPurchasePrice = Console.readLine();
            purchasePrice = parseInt(rawPurchasePrice);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getError());
        }
        return purchasePrice;
    }

    public static Lotto readWinningNum(){
        String rawWinningInput = Console.readLine();
        return new Lotto(Arrays.asList(rawWinningInput.split(DELIMITER)).stream()
                .map(InputView::parseInt)
                .collect(Collectors.toList()));
    }

    public static int readBonus(Lotto answer){
        String rawBonus = Console.readLine();
        int bonus = parseInt(rawBonus);
        checkBonus(bonus, answer);
        checkRange(bonus);
        return bonus;
    }

    public static int parseInt(String strNum) {
        int result = 0;
        try{
            result = Integer.parseInt(strNum);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getError());
        }
        return result;
    }

    public static void checkBonus(int bonusNumber, Lotto answer){
        if(!(answer.getNumbers().stream()
                .allMatch(number -> number != bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.getError());
        }
    }

    public static void checkRange(int lottoNumber){
        if(!(lottoNumber >= 1 && lottoNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE.getError());
        }
    }

    public static boolean checkRangeList(List<Integer> numbers){
        return numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);
    }
}
