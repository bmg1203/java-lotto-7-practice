package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        int count = Integer.parseInt(Console.readLine());
        List<Lotto> lottos = new ArrayList<>();

        count /= 1000;

        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto( Randoms.pickUniqueNumbersInRange(1,45,6)));
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNum = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(Console.readLine(),",");
        for (int i = 0; i < st.countTokens(); i++) {
            winningNum.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());

        for (Lotto lotto : lottos) {
            lotto.read(winningNum, bonus);
        }



     

    }
}
