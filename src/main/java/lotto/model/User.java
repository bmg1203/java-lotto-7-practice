package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Result;

public class User {

    public int money;

    public int bonusNumber;

    public List<List<Integer>> lotteryTickets = new ArrayList<>();

    public User(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        if (!money.matches("-?\\d+") || money.isBlank()) {
            throw new IllegalArgumentException("[ERROR] "
                    + "0 이상의 1000 단위로 나누어 떨어지는 숫자를 "
                    + "공백없이 입력해야합니다."
                    + " ex)8000");
        }

        int number = Integer.parseInt(money);
        if (number < 0 || (number % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] "
                    + "0 이상의 1000 단위로 나누어 떨어지는 숫자를 "
                    + "공백없이 입력해야합니다."
                    + " ex)8000");
        }
    }

    public void specifyBonusNumber(String bonusNumber) {
        bonusNumberValidate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void bonusNumberValidate(String bonusNumber) {
        if (!bonusNumber.matches("-?\\d+") || bonusNumber.isBlank()) {
            throw new IllegalArgumentException("[ERROR] "
                    + "보너스 점수는 1~45인 숫자를 공백 없이 입력 해야 합니다.");
        }

        int number = Integer.parseInt(bonusNumber);
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] "
                    + "보너스 점수는 1~45인 숫자를 공백 없이 입력 해야 합니다.");
        }
    }

    public void moneyToTicket(int money) {
        publishLotto(money / 1000);
    }

    public void publishLotto(int count) {
        for (int i = 0; i < count; i++) {
            lotteryTickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public Double lateOfReturn() {
        double returnMoney = 0;
        for (Result result : Result.values()) {
            returnMoney += result.getMoney() * result.getCount();
        }
        double result = returnMoney / money * 100;
        return (double) Math.round(result * 100) / 100.0;
    }
}
