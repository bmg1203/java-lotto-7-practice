package lotto.model.draw;

import java.util.List;
import lotto.model.lotto.Lotto;

public class WinningLotto {

    private final Lotto winningLotto;

    private WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static WinningLotto from(String input) {
        validateInputEmpty(input);
        List<String> splitInput = List.of(input.split(",", -1));
        validateNumeric(splitInput);
        List<Integer> numbers = splitInput.stream()
                .map(number ->
                        Integer.parseInt(number.strip())
                ).toList();
        return new WinningLotto(new Lotto(numbers));
    }

    private static void validateInputEmpty(String input) {
        if ( input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 빈 값입니다.");
        }
    }

    private static void validateNumeric(List<String> splitInput) {
        try {
            splitInput.forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
        }
    }

    public boolean isContain(int number) {
        return winningLotto.isContain(number);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    @Override
    public String toString() {
        return winningLotto.toString();
    }
}
