package lotto.domain;

public record Money(int money) {
    private static final int LOTTO_PRICE = 1000;

    public Money{
        validateLottoMoney(money);
    }

    private void validateLottoMoney(final int money){
        if (money <= 0 || money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위로 입력 해야합니다.");
        }
    }

    public int getLottoCount(){
        return money / LOTTO_PRICE;
    }
}
