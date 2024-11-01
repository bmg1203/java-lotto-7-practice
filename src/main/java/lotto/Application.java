package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        String input_pay = readLine();
        Integer number_of_times = Integer.valueOf(input_pay) / 1000;
        System.out.println("\n" + number_of_times + "개를 구매했습니다.");
        List<Lotto> all_lottos = new ArrayList<>();
        for (int i = 0; i < number_of_times; i++) {
            List<Integer> marked_numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            marked_numbers.sort(Comparator.naturalOrder());
            all_lottos.add(new Lotto(marked_numbers));
            String output_one = marked_numbers.stream()
                                              .map(String::valueOf)
                                              .collect(Collectors.joining(","));
            System.out.println("[" + output_one + "]");
        }
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input_numbers = readLine();
        List<Integer> golden_numbers = Arrays.stream(input_numbers.split(","))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input_bonus = readLine();
        Integer bonus_number = Integer.getInteger(input_bonus);
        System.out.println("\n당첨 통계\n---");

    }
}
