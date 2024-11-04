package lotto.model.exception;

import lotto.common.exception.CustomException;

public final class LottoNumberInvalidException extends IllegalArgumentException implements CustomException {

    private LottoNumberInvalidException(String message) {
        super(message);
    }

    public static IllegalArgumentException lottoNumberRange(String... details) {
        String message = CustomException.appendDetails("로또 번호의 범위가 잘못되었습니다.", details);
        return new LottoNumberInvalidException(message);
    }

    public static IllegalArgumentException tooManyLottoNumbersSize(String... details) {
        String message = CustomException.appendDetails("생성 가능한 로또 번호의 개수를 초과했습니다.", details);
        return new LottoNumberInvalidException(message);
    }

    public static IllegalArgumentException lottoNumberSize(String... details) {
        String message = CustomException.appendDetails("로또 번호의 개수가 잘못되었습니다.", details);
        return new LottoNumberInvalidException(message);
    }

    public static IllegalArgumentException lottoNumberDuplicate() {
        return new LottoNumberInvalidException("로또 번호는 중복되지 않아야 합니다.");
    }

    public static IllegalArgumentException bonusNumberDuplicate() {
        return new LottoNumberInvalidException("보너스 번호가 당첨 번호에 포함되서는 안됩니다.");
    }
}
