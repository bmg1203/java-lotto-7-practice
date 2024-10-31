package lotto;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
            .sorted()
            .map(LottoNumber::valueOf).toList();
    }

    public String represent() {
        String nums = String.join(", ", numbers.stream()
            .map(LottoNumber::toString).toList());
        return "[" + nums + "]";
    }

    // TODO: 에러 메시지가 6개 이상일 때 enum 으로 관리!
    // TODO: 추후 메서드 분리
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
