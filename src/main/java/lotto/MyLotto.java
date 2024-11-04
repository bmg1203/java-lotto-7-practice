package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class MyLotto {
    private final List<Lotto> myLotto;

    public MyLotto(int lottoCount) {
        this.myLotto = IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }

    public void matchNumbers(List<Integer> winningNumbers) {
        Lotto winningNumber = new Lotto(winningNumbers);

        myLotto.stream()
                .forEach(i -> i.matchNumbers(winningNumber));
    }

    public int getCount() {
        return myLotto.size();
    }

    public void print() {
        System.out.println(getCount()+"개를 구매했습니다.");
        myLotto.stream()
                .forEach(System.out::println);
    }
}
