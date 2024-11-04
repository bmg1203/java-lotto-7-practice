package initialTest;

import constant.ErrorConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InitialTest {
    PurchasedLottoRepository purchasedLottoRepository;
    WinningNumberRepository winningNumberRepository;
    Lotto lotto1;
    Lotto lotto2;
    Lotto lotto3;
    Lotto lotto4;
    Lotto winningLotto;


    @BeforeEach
    void beforEach(){
        purchasedLottoRepository = new PurchasedLottoRepository();
        winningNumberRepository=new WinningNumberRepository();
    }

    @Test
    public void 로또_범위_테스트_45_초과(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new lotto.Lotto(List.of(1, 2, 3, 4, 5, 46)));

    }

    @Test
    public void 로또_범위_테스트_0_이하(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new lotto.Lotto(List.of(1, 2, 3, 4, 5, 0)));

    }

    @Test
    void 구매한_로또_저장(){
        lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(List.of(7,8,9,10,11,12));
        lotto3 = new Lotto(List.of(14,15,16,17,18,19));
        lotto4 = new Lotto(List.of(20,21,22,23,24,25));
        purchasedLottoRepository.saveMyLotto(lotto1);
        purchasedLottoRepository.saveMyLotto(lotto2);
        purchasedLottoRepository.saveMyLotto(lotto3);
        purchasedLottoRepository.saveMyLotto(lotto4);
        List<Lotto> myAllLotto = purchasedLottoRepository.findMyAllLotto();

        Assertions.assertEquals(lotto1,myAllLotto.get(0));
        Assertions.assertEquals(lotto2,myAllLotto.get(1));
        Assertions.assertEquals(lotto3,myAllLotto.get(2));
        Assertions.assertEquals(lotto4,myAllLotto.get(3));

    }

    @Test
    void 당첨번호저장(){

        winningNumberRepository.makeWinningNumbers("1, 2, 3, 4, 5, 6");
        List<Integer> winningLotto = winningNumberRepository.findWinningLotto();
        List<Integer> expectedLotto = winningNumberRepository.findWinningLotto();
        Assertions.assertEquals(expectedLotto,winningLotto);


    }


    @Test
    void 구매로또_당첨여부_확인_테스트(){
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber=new BonusNumber(7);


        lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7));



        WinningLottoNumber winningLottoNumber=new WinningLottoNumber(winningLotto,bonusNumber);
        int matchCount = winningLottoNumber.calculateMatchCount(lotto1);
        boolean bonusMatch = winningLottoNumber.isBonusMatch(lotto1);


        Assertions.assertEquals(5,matchCount);
        Assertions.assertEquals(true,bonusMatch);


    }



}

class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        this.numbers = new ArrayList<>(numbers);
        validate(numbers);
        sortNumbers();
    }

    private void sortNumbers(){
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i)>45  || numbers.get(i)<1  ){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 값이어야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int number=numbers.get(i);
            if(numbers.indexOf(number)!=numbers.lastIndexOf(number)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어서는 안됩니다.");
            }
        }

    }

    public List<Integer> getLottoNumbers(){
        return new ArrayList<>(numbers);
    }
}


class PurchasedLottoRepository {

    private final List<Lotto> myLottoRepository=new ArrayList<>();

    public void saveMyLotto(Lotto lotto){
        myLottoRepository.add(lotto);
    }

    public List<Lotto> findMyAllLotto(){
        return new ArrayList<>(myLottoRepository);
    }


}






class WinningNumberRepository {

    private final List<Integer> winningNumbersRepository = new ArrayList<>();

    public void saveWinningLotto(int number) {
        winningNumbersRepository.add(number);
    }

    public List<Integer> findWinningLotto() {

        return new ArrayList<>(winningNumbersRepository);
    }

    private String deleteBlank(String input) {
        input = input.strip();
        return input;
    }

    public void makeWinningNumbers(String winningNumbersInput) {
        winningNumbersRepository.clear();
        String[] winningNumbers = winningNumbersInput.split(",", -1);

        for (String winningNumber : winningNumbers) {
            winningNumber = deleteBlank(winningNumber);
            int parsedwinningNumber;
            try {
                parsedwinningNumber = Integer.parseInt(winningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자로 파싱 할 수 없습니다.");
            }
            saveWinningLotto(parsedwinningNumber);
        }

    }

}



     class WinningLottoNumber  {
        private final Lotto winningLotto;
        private final BonusNumber bonusNumber;


        public WinningLottoNumber(Lotto winningLotto, BonusNumber bonusNumber) {
            this.winningLotto = winningLotto;
            this.bonusNumber = bonusNumber;
            validateDuplicateBonusNumber();
        }


        private void validateDuplicateBonusNumber() {
            if (winningLotto.getLottoNumbers().contains(bonusNumber.getBonusNumber())) {
                throw new IllegalArgumentException(ErrorConst.ERROR_DUPLICATE_BONUS_NUMBER);
            }
        }

         public boolean isBonusMatch(Lotto myLotto ) {
            List<Integer> lottoNumbers = myLotto.getLottoNumbers();

            return lottoNumbers.contains(bonusNumber.getBonusNumber());
        }


         public int calculateMatchCount(Lotto myLotto) {
            int count = 0;
             List<Integer> winningNumbers = winningLotto.getLottoNumbers();
             for (Integer number : myLotto.getLottoNumbers()) {
                if (winningNumbers.contains(number)) {
                    count++;
                }
            }
            return count;
        }


    }


     class BonusNumber {

        private final int bonusNumber;

         public BonusNumber(int bonusNumber) {
             validateBonusNumberRange(bonusNumber);
             this.bonusNumber = bonusNumber;
        }


        public int getBonusNumber() {
            return bonusNumber;
        }

        private static void validateBonusNumberRange(int parsedBonusNumber) {

            if (parsedBonusNumber > 45 || parsedBonusNumber < 1) {
                throw new IllegalArgumentException(ErrorConst.ERROR_BONUS_NUMBER_RANGE);
            }

        }


    }




