package lotto.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.exception.ErrorStatus;

public class Lottos {

    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void buyLottos(Long money) {
        validateMoney(money);
        int numberOfLottos = (int) (money / 1000);
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public Integer getNumberOfLottos() {
        return lottos.size();
    }

    public void setWinningNumbers(List<Integer> numbers) {
        validateWinningNumbers(numbers);
        this.winningNumbers = numbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public float getRateOfReturn() {
        int spendMoney = lottos.size() * 1000;
        int earnMoney = 0;
        for (Lotto lotto : lottos) {
            Prize prize = lotto.checkPrize(winningNumbers, bonusNumber);
            earnMoney += prize.getAmount();
        }
        return (float) earnMoney / spendMoney * 100;
    }

    public int getCountOfPrize(Prize prize) {
        int count = 0;
        for (Lotto lotto : lottos) {
            if (prize == lotto.checkPrize(winningNumbers, bonusNumber)) {
                count++;
            }
        }
        return count;
    }

    private void validateMoney(Long money) {
        // 구입 금액이 int 형을 초과하는 경우
        if (money > 2147483000) {
            throw new IllegalArgumentException(ErrorStatus.MONEY_OUT_OF_RANGE.getMessage());
        }

        // 로또 구입 금액이 1,000원 단위가 아닌 경우
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_MONEY_AMOUNT.getMessage());
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        // 로또 개수 체크
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_COUNT_OF_LOTTO_NUMBERS.getMessage());
        }

        // 중복 값 체크
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorStatus.DUPLICATE_NUMBER.getMessage());
        }

        // 로또 숫자 값 1~45 사이의 값인지 체크
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorStatus.NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateBonusNumber(Integer bonusNumber) {
        // 로또 숫자 값 1~45 사이의 값인지 체크
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorStatus.NUMBER_OUT_OF_RANGE.getMessage());
        }

        // 보너스 숫자에 중복이 있는지 체크
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorStatus.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}