package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static List<Integer> splitNumbers(String lottoWinningNumber) {
        String[] winningNumbers = lottoWinningNumber.split(",");

        List<Integer> lottoWinningNumbers = new ArrayList<>();

        //배열의 각 문자열을 정수로 변환하여 리스트에 추가
        for (String number : winningNumbers) {
            lottoWinningNumbers.add(Integer.parseInt(number.strip()));
        }

        return lottoWinningNumbers;
    }

    public static List<Integer> checkValidLottoNumbers(List<Integer> lottoWinningNumbers) { // 로또 번호 체크
        Set<Integer> lottoNumbersSet = new HashSet<>(lottoWinningNumbers);

        if (lottoWinningNumbers.size() != 6) throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 총 6개 이하 입니다.");
        if (lottoNumbersSet.size() != 6) throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다."); // 중복 검사

        for (var number : lottoNumbersSet) {
            if (number < 1 || number > 45) throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1이상 45이하 입니다.");
        }
        Collections.sort(lottoWinningNumbers);
        return lottoWinningNumbers;
    }

    public static int checkAmount(int buyLottoAmount) { // 금액 체크
        if (buyLottoAmount % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위 금액이 아닙니다.");
        return buyLottoAmount / 1000;
    }

    public static List<List<Integer>> randomLottoNumberPick(int buyLottoAmount) { // 랜덤 로또 넘버 생성
        List<List<Integer>> buyLottoNumbers = new ArrayList<>();
        for (int i = 0; i < buyLottoAmount; ++i) {
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)); // 불변 객체 복사본 생성
            Collections.sort(lottoNumbers);
            buyLottoNumbers.add(lottoNumbers);
        }
        return buyLottoNumbers;
    }

    public static void printBuyLottoNumbers(List<List<Integer>> buyLottoNumbers){ // 랜덤 로또 번호 출력
        for(var numbers : buyLottoNumbers){
            System.out.println(numbers);
        }
    }

    public static int checkRange(int bonusNumber) { // 보너스 넘버 범위 체크
        try {
            if (bonusNumber < 1 || bonusNumber > 45)
                throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1이상 45이하 입니다.");
        }
        catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return bonusNumber;
    }

    public static int inputLottoAmount(){
        int buyLottoAmount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                buyLottoAmount = checkAmount(Integer.parseInt(Console.readLine()));
                validInput = true;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return buyLottoAmount;
    }

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        int buyLottoAmount = inputLottoAmount();
        System.out.println("\n" + buyLottoAmount + "개를 구매했습니다.");
        List<List<Integer>> buyLottoNumbers = randomLottoNumberPick(buyLottoAmount); // 랜덤로또 생성
        printBuyLottoNumbers(buyLottoNumbers);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String lottoWinningNumber = Console.readLine(); // 당첨 번호 입력
        List<Integer> lottoWinningNumbers = checkValidLottoNumbers(splitNumbers(lottoWinningNumber)); // 당첨번호 생성

        Lotto lotto = new Lotto(lottoWinningNumbers); // 로또 생성

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = checkRange(Integer.parseInt(Console.readLine()));

        lotto.calculateStatistics(buyLottoNumbers, bonusNumber, buyLottoAmount);
    }
}



