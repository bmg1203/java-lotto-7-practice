package lotto.domain;

public class Money {
    private long amount;
    private static final long MINIMUM_LOTTO_PRICE = 1000;
    private static final long LOTTO_PRICE_UNIT = 1000;

    public Money(long money) {
        validateMoney(money);
        this.amount = money;
    }

    private void validateMoney(long money) {
        validateMinimumAmount(money);
        validateDivisibleByLottoPrice(money);

    }

    private void validateMinimumAmount(long money) {
        if (money < MINIMUM_LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구매는 1000원부터 가능합니다.");
        }
    }

    private void validateDivisibleByLottoPrice(long money) {
        if (money % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("로또 구매는 1000원 단위로 가능합니다");
        }
    }



    public long getLottoQuantity() {
        return amount / LOTTO_PRICE_UNIT;
    }




}
