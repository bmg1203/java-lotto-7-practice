package lotto.constants.message;

public enum InputError implements Message {
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또의 번호 조합에 중복이 숫자가 발견되었습니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 숫자가 당첨 번호 안에 이미 존재합니다.");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
