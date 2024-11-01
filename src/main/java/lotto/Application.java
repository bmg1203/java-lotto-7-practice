package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyText = Console.readLine();
        long money = Money.buy(moneyText); // String 변수 moneyText를 long형으로 변환 및 유효성 검사

        String lottoText = Console.readLine();
        Lotto lotto = new Lotto(lottoText); // String 변수 lottoText를 long형으로 변환 및 유효성 검사

        System.out.println(lotto.getNumbers());
    }
}
