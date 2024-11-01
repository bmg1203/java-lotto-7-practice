package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public int getPurchaseAmount(){
        System.out.println("구매 금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumericNumber(input);
        Integer purchaseAmount = Integer.valueOf(input);
        validateThousandUnit(purchaseAmount);
        return purchaseAmount;
    }

    public List<Lotto> generateLottos(int purchaseAmount){
        int ticket = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            lottos.add(Lotto.generate());
        }
        System.out.println(ticket + "개를 구매하였습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }

    public Lotto getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = parseWinningNumbers(input);
        return new Lotto(winningNumbers);
    }

    private static List<Integer> parseWinningNumbers(String input) {
        String[] tokens = input.split(",");
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for (String token : tokens) {
            winningNumbers.add(Integer.parseInt(token));
        }
        return winningNumbers;
    }

    public static void validateNumericNumber(String input){
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
            }
        }
    }

    public static void validateThousandUnit(int purchaseNumber){
        if(purchaseNumber % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }
}
