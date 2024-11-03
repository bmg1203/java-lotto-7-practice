package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_BUDGET = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER= "당첨 번호를 입력해 주세요.";

    public int readBudget(){
        System.out.println(INPUT_BUDGET);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
    public List<Integer> readWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        //검증하기
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
