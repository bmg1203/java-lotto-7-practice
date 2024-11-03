package lotto.domain;

import lotto.exception.LottoException;

public record LottoNumber(int number) {

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    public LottoNumber {
        validate(number);
    }

    private void validate(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoException("로또 번호는 " + MIN_NUMBER + "에서 " + MAX_NUMBER + " 사이의 값이어야 합니다.");
        }
    }
}
