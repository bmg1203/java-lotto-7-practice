package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputMoney {
    public String inputMoney;
    public int paidPrice;
    public int purchaseNumber;

    public int inputMoneyToBuyLotto() {
        boolean continueLoop = true;

        while (continueLoop) {      // 예외 발생 시 재입력 반복
            System.out.println("구입금액을 입력해 주세요.");
            inputMoney = Console.readLine();

            removeComma(inputMoney);                // 입력 금액 쉼표(,) 제거
            validateInputMoney(inputMoney);         // 입력 금액 검증
            continueLoop = false;
        }

        purchaseNumber = paidPrice / 1000;      // 구매 수량 저장
        return purchaseNumber;
    }

    // 쉼표가 존재하고 쉼표 뒤에 3자리의 숫자 연속되면 쉼표 제거
    public String removeComma(String inputMoney) {
        if (inputMoney.contains(",") && inputMoney.matches(".*,[0-9]{3,}.*")) {
            return inputMoney.replaceAll(",", "");
        }
        return inputMoney;
    }

    // 입력 금액 검증
    public int validateInputMoney(String inputMoney) {
        paidPrice = checkForNonNumericCharacters(inputMoney);       // 문자나 기호 체크 후 정수 변환
        checkNegative(paidPrice);           // 음수 체크
        checkIfThousandUnit(paidPrice);     // 1000의 배수 체크
        return paidPrice;
    }

    // 문자나 기호 체크 후 정수 변환
    public int checkForNonNumericCharacters(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);    // 정수 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자와 3자리 단위를 구분하는 쉼표(,)로만 입력 가능합니다.\n다시 입력해 주세요.");
        }
    }

    // 음수 체크
    public void checkNegative(int paidPrice) {
        if (paidPrice < 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 음수가 될 수 없습니다.\n다시 입력해 주세요.");
        }
    }

    // 1000 의 배수 체크
    public void checkIfThousandUnit(int paidPrice) {
        if (paidPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로만 입력 가능합니다.\n다시 입력해 주세요.");
        }
    }
}