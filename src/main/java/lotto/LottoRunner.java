package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoRunner {

    public void start() {
        int money = 1;
        while (money % 1000 != 0) {
            System.out.println("구입금액을 입력해 주세요.");
            money = Integer.parseInt(Console.readLine());
            try {
                validate(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            lottos.add(new Lotto(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        Lotto targetLotto = null;
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String nums = Console.readLine();
            try {
                List<Integer> lottoNums = Arrays.stream(nums.split(",")).mapToInt(Integer::parseInt).boxed().toList();
                this.validateLottoNum(lottoNums);
                targetLotto = new Lotto(lottoNums);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        final Bonus bonus = new Bonus(targetLotto);
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                int num = Integer.parseInt(Console.readLine());
                validateLottoNum(num);
                bonus.setNum(num);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        Calculator calculator = new Calculator(lottos, targetLotto, bonus);
        System.out.println(calculator.getResult());
    }

    private void validate(int money) throws IllegalArgumentException {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 단위의 숫자로 입력해주세요.");
        }
    }

    private void validateLottoNum(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumRange);
    }

    private void validateLottoNum(int num) {
        this.validateLottoNumRange(num);
    }

    private void validateLottoNumRange(int target) {
        if (target < 1 || target > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
