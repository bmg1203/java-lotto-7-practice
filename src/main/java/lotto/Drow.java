package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class Drow {

    List<Integer> drowNumbers = new ArrayList<>(); // 당첨 번호
    Integer bonusNumber; // 보너스 번호

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INPUT_DRAW_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_IS_NOT_NUMBER = "당첨 번호와 보너스 번호는 슷지만 입력할 수 있습니다.";
    private static final String ERROR_NUMBER_COUNT = "당첨 번호는 6개여야 합니다.";
    private static final String ERROR_DUPLICATE_NUMBER = "당첨 번호는 서로 중복되지 않아야합니다.";
    private static final String ERROR_DUPLICATE_BONUS = "보너스 번호는 당첨 번호와 중복되지 않아야합니다.";
    private static final String ERROR_NUMBER_RANGE_SMALL = "당첨 번호는 1보다 커야합니다.";
    private static final String ERROR_NUMBER_RANGE_BIG = "당첨 번호는 45보다 작아야합니다.";

    /// 당첨 번호 입력 및 예외처리
    public void inputDrowNumbers() {

        boolean validation;

        do {// 유효한 값을 입력받을때까지 반복
            validation = true;
            String userInput = inputNumbers(INPUT_DRAW_NUMBERS_PROMPT); // 당첨번호 입력
            validation = validateDrowNumberInput(userInput); // 당첨번호 입력 관련 예외처리
            setDrowNumbers(userInput); // 당첨번호 저장
            validation = validateDuplicateNumber(drowNumbers); // 당첨번호 중복 관련 예외처리

        } while (!validation); // 모든 밸리디에이션에 충족하면 다음 로직으로 넘어감

    }

    ///보너스 번호 입력
    public void inputBonusNumber() {

        boolean validation;

        do {
            validation = true;
            String userInput = inputNumbers(INPUT_BONUS_NUMBER_PROMPT); //보너스번호 입력
            validation = validateNumber(userInput); // 보너스번호 입력 관련 예외처리
            setBonusNumber(userInput); // 보너스번호 저장
            validation = validateDuplicateBonusNumber(drowNumbers, bonusNumber); // 보너스번호 중복 관련 예외처리

        } while (!validation); // 유효한 값을 입력받을때까지 반복
    }


    ///입력한 당첨 번호들을 배열에 저장
    private void setDrowNumbers(String userInput) {

        drowNumbers = new ArrayList<>();
        String[] inputNumbers = userInput.split(",");

        for (String inputNumber : inputNumbers) {
            drowNumbers.add(Integer.parseInt(inputNumber)); // 당첨번호 배열에 저장
        }
    }

    ///입력한 보너스 번호를 저장
    private void setBonusNumber(String userInput) {
        bonusNumber = Integer.parseInt(userInput);
    }


    /// 당첨 번호 입력 메소드
    private String inputNumbers(String description) {

        String userInput;

        System.out.println(description);
        userInput = Console.readLine(); // 유저로부터 입력받은 금액을 저장
        userInput = userInput.trim();

        return userInput;
    }


    /// 사용자 입력 예외처리
    public boolean validateDrowNumberInput(String userInput) {

        String[] inputNumbers = userInput.split(",");

        if (!validateNumberCount(inputNumbers)) return false;

        for (String inputNumber : inputNumbers) {

            if (!validateNumber(inputNumber)) {
                return false;
            }
        }

        return true;
    }

    public boolean validateDuplicateNumber(List<Integer> checkNumbers) {

        HashSet<Integer> numbersSet = new HashSet<>(checkNumbers);

        try {
            if (numbersSet.size() < 6) { // 중복되는 숫자가 있어, numberSet의 길이가 6이되지 않을 경우
                throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
            }

            return true;

        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return false;
        }
    }

    /// 배열 길이가 6안지 확인
    private boolean validateNumberCount(String[] inputNumbers) {

        try {
            if (inputNumbers.length != 6) {
                throw new IllegalArgumentException(ERROR_NUMBER_COUNT);
            }
            return true;

        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return false;
        }
    }

    /// 입력 값의 범위 및 숫자 여부 확인
    boolean validateNumber(String inputNumber) {

        inputNumber = inputNumber.trim();

        if (!validateIsNumber(inputNumber)) {
            return false;
        }

        int number = Integer.parseInt(inputNumber);

        if (!validateNumberRange(number)) {
            return false;
        }

        return true;
    }

    /// 보너스 번호가 당첨 번호와 중볻되는지 확인
    public boolean validateDuplicateBonusNumber(List<Integer> checkNumbers, Integer bonusNumber) {

        HashSet<Integer> numbersSet = new HashSet<>(checkNumbers); // HashSet의 빠른 조회 기능을 통해 중복 확인

        try {

            if (numbersSet.contains(bonusNumber)) { // 보너스 번호가 당첨 숫자에 포함될 경우
                throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS);
            }
            return true;

        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + " " + e.getMessage());
            return false;
        }
    }

    /// 입력받은 값이 숫자로 이루어져있는지 확인
    private boolean validateIsNumber(String inputNumber) {

        try {
            inputNumber = inputNumber.trim(); // 양쪽 여백 제거
            int number = Integer.parseInt(inputNumber); // 숫자가 아닌 값을 포맷할 경우, NumberFormatException 발생
            return true;

        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE + " " + ERROR_IS_NOT_NUMBER);
            return false;
        }
    }

    /// 숫자가 1~45 범위 안에 있는지 확인
    private boolean validateNumberRange(int number) {

        try {

            if (number < 1) {
                throw new IllegalArgumentException(ERROR_NUMBER_RANGE_SMALL);
            }
            if (number > 45) {
                throw new IllegalArgumentException(ERROR_NUMBER_RANGE_BIG);
            }
            return true;

        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + " " + e.getMessage());
            return false;
        }
    }

    public void drowLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            compareNumber(lotto);
        }
        printPrize();
        double rate = getRate(lottos.size() * 1000); // 로또 1 장에 1000원이라는점을 이용하여 구매비용을 구함
        printRate(rate);
    }

    /// 로또 번호와 당첨 번호를 비교하여 추첨
    public void compareNumber(Lotto lotto) {

        List<Integer> numbers = lotto.getNumbers(); // 로또 별 번호 정보를 받아옴
        Set<Integer> numbersSet = new HashSet<>(numbers); // Set의 contains를 이용하여 일치하는 갯수 확인

        int validCount = getValidCount(numbersSet);
        boolean bonus = getBonus(numbersSet);

        getPrize(validCount, bonus);
    }

    /// 일치하는 번호의 갯수 계산
    private int getValidCount(Set<Integer> numbersSet) {

        int count = 0;

        for (int drowNumber : drowNumbers) {
            if (numbersSet.contains(drowNumber)) {
                count++;
            }
        }

        return count;
    }

    /// 보너스 번호 일치 여부 계산
    private boolean getBonus(Set<Integer> numbersSet) {
        return numbersSet.contains(bonusNumber);
    }

    /// 일치하는 번호 갯수와 보너스 번호 여부를 통해 등수 계산
    private void getPrize(int validCount, boolean bonus) {

        if (validCount == 6) {
            Prize.First.increaseCount();
        }
        if (validCount == 5 && bonus) {
            Prize.Second.increaseCount();
        }
        if (validCount == 5 && !bonus) {
            Prize.Third.increaseCount();
        }
        if (validCount == 4) {
            Prize.Fourth.increaseCount();
        }
        if (validCount == 3) {
            Prize.Fifth.increaseCount();
        }

    }

    /// 등수 별 상금 및 당첨갯수 출력
    public void printPrize() {

        Prize.Fifth.printPrizeInfo();
        Prize.Fourth.printPrizeInfo();
        Prize.Third.printPrizeInfo();
        Prize.Second.printPrizeInfo();
        Prize.First.printPrizeInfo();

    }

    /// 수익률 계산
    public double getRate(int inputMoney) {

        long prizeMoney = 0; //전체 상금
        prizeMoney += Prize.First.getPrizeMoney();
        prizeMoney += Prize.Second.getPrizeMoney();
        prizeMoney += Prize.Third.getPrizeMoney();
        prizeMoney += Prize.Fourth.getPrizeMoney();
        prizeMoney += Prize.Fifth.getPrizeMoney();

        return (double) prizeMoney * 100 / inputMoney; //수익률: (전체 상금 x 100) / 지불한 금액
    }

    /// 수익률 출력
    public void printRate(double rate) {

        String rateInfo = "총 수익률은 " + String.format("%.1f", rate) + "%입니다.";
        System.out.println(rateInfo);

    }

}
