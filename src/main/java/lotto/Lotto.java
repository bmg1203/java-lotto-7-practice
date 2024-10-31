package lotto;

import static lotto.domain.MAGIC_NUMBER.SIZE;
import static lotto.domain.MAGIC_NUMBER.START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 예외 처리
    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE.getMagicNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현



}
