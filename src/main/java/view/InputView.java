package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputView(){

    }
    public String purchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine().strip();
    }

}
