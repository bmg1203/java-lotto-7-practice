package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");

        String account = Console.readLine();

        if (!account.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력하세요.");
        }

    }
}
