package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

    public static int getPurchaseAmount(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static List<Integer> getWinningNumbers(Scanner scanner) {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = scanner.nextLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String num : input) {
            winningNumbers.add(Integer.parseInt(num.trim()));
        }
        return winningNumbers;
    }

    public static int getBonusNumber(Scanner scanner) {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
