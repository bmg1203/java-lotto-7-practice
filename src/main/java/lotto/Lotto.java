package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateNumberRepeat();
        validateNumberRange();
    }

    public void validateNumberRange() {
        for (int number : numbers) {
            if (number > 45 || number < 0) {
                throw new IllegalArgumentException("range");
            }
        }
    }
    public void validateNumberRepeat(){
        if (numbers.stream().distinct().toList().size() != numbers.size()){
            throw new IllegalArgumentException("중복");
        }
    }

//    public void validateNumberEmpty(){
//        if (numbers.stream().anyMatch(Integer::)){
//            throw new IllegalArgumentException("중복");
//        }
//    }

    // TODO: 추가 기능 구현
}
