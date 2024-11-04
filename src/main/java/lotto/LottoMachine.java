package lotto;

import lotto.numberGenerator.LottoRandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_PER_PRICE = 1000;
    private int userMoney;
    private List<Lotto> lotto = new ArrayList<>();
    private static InputReader inputReader = new InputReader();
    private static LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();

    public int readLottoPrice() {
        System.out.println("구입금액을 입력해 주세요");
        String money = inputReader.readUserInput();
        while (Integer.parseInt(money) % LOTTO_PER_PRICE != 0) {
            System.out.println("[ERROR] 구입 금액은 " + LOTTO_PER_PRICE + "원 단위로 입력해주세요.");
            money = inputReader.readUserInput();
        }
        userMoney = Integer.parseInt(money);
        return userMoney;
    }

    public int calculateLottoCount(int userMoney) {
        return userMoney / LOTTO_PER_PRICE;
    }

    public Lotto purchaseLotto() {
        return lottoRandomNumberGenerator.generateLottoNumbers();
    }

    public void vendorLotto(){
        int lottoCount = calculateLottoCount(userMoney);
        System.out.println(lottoCount + "개를 구매했습니다.");
        for(int i=0; i<lottoCount; ++i){
            Lotto purchased = purchaseLotto();
            System.out.println(purchased);
            lotto.add(purchased);
        }
    }

    public Lotto readWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = inputReader.readUserInput();
        List<Integer> winningLottoNumbers = Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lotto winningLotto = new Lotto(winningLottoNumbers);
        return winningLotto;
    }

    public int readBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = inputReader.readUserInput();
        return Integer.parseInt(userInput);
    }
}
