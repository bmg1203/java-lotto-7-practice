package lotto.constants;

/**
 * 로또 관련 상수를 관리하는 클래스
 */
public final class LottoConstants {
    // 로또 번호 범위
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    // 로또 가격
    public static final int LOTTO_PRICE = 1_000;

    private LottoConstants() {
        // 인스턴스화 방지
    }

}
