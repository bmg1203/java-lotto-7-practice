package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class GamePlay {

    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";
    private static final String LIST_START = "[";
    private static final String LIST_END = "]";
    private static final String COMMA = ",";
    private static final String LINE_BREAK = "\n";

    private List<Lotto> lottos = new ArrayList<>();
    private int useMoneys;
    private Lotto winningLotto;
    private int bonusNumber;

    public GamePlay() {
        useMoneys = getMoney();
        buyLotto();
        winningLotto = getWinningLotto();
        bonusNumber = getBonusNumber();

        displayResult();
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private Lotto getWinningLotto() {
        System.out.println("당첨 번호 6자리를 입력해주세요. (,) 쉼표를 기준으로 구분됩니다.");

        return new Lotto(stream(Console.readLine().split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private int getMoney() {
        System.out.println("로또 구입 금액을 입력해주세요. 단, 1000원 단위로 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    private void buyLotto() {
        for(int i=0; i<useMoneys / LOTTO_PRICE; i++){
            lottos.add(pickLotto());
        }

        printLottos();
    }

    private Lotto pickLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void printLottos() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size() + "개를 구매했습니다.\n");

        for(Lotto lotto : lottos){
            sb.append(LIST_START);
            List<Integer> numbers = lotto.getNumbers();
            sb.append(numbers.getFirst());
            for(int i=1; i<numbers.size(); i++){
                sb.append(COMMA).append(numbers.get(i));
            }
            sb.append(LIST_END).append(LINE_BREAK);
        }

        System.out.println(sb.toString());
    }

    private Map<Rank, Integer> calculateLotto() {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        for(Rank rank : Rank.values()){
            results.put(rank, 0);
        }

        for(Lotto lotto : lottos){
            Rank rank = calculateRank(lotto);
            if(rank != null){
                results.put(rank, results.get(rank) + 1);
            }
        }

        return results;
    }

    private Rank calculateRank(Lotto lotto) {
        int matchCount = 0;
        boolean matchBonus = false;
        for(int number : winningLotto.getNumbers()){
            if(lotto.contains(number)){
                matchCount++;
            }
        }

        if(lotto.contains(bonusNumber)) matchBonus = true;

        return Rank.valueOf(matchCount, matchBonus);
    }

    private void displayResult() {
        StringBuilder sb = new StringBuilder();
        Map<Rank, Integer> results = calculateLotto();

        sb.append(LINE_BREAK).append("당첨 통계").append(LINE_BREAK)
                .append("---").append(LINE_BREAK);

        Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(Rank::getPrize).reversed())
                .forEach(rank -> sb.append(rank.getDescription())
                        .append(" - ").append(results.get(rank))
                        .append("개").append(LINE_BREAK));

        System.out.println(sb.toString());
    }
}
