package lotto.view;

import lotto.model.Amount;

public class OutputView {
    public void printCount(Amount amount){
        System.out.println(amount.getCount() + "개를 구입하셨습니다.");
    }
}
