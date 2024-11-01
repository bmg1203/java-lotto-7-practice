package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.LottoInputDTO;
import lotto.utils.Validator;

public class InputView {
    private final OutputView outputView = new OutputView();

    public LottoInputDTO inputLottoData() {
        String purchaseAmount = inputPurchaseAmount();
        String[] winningNumbers = inputWinningLotto();
        String bonusNumber = inputBonusNumber(winningNumbers);

        // 모든 입력 값을 담아 DTO로 생성
        return new LottoInputDTO(Integer.parseInt(purchaseAmount), winningNumbers, bonusNumber);
    }

    public String inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String purchaseAmount = Console.readLine();
                // 유효성 검증
                Validator.checkPurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    public String[] inputWinningLotto() {
        while (true) {
            try {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                String input = Console.readLine().replace("\\s", "");
                String[] winningNumbers = input.split(",");
                // 유효성 검증
                Validator.checkWinningLottoNumbers(winningNumbers, "6개의 당첨 번호를 입력해야 합니다.");
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    public String inputBonusNumber(String[] winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 볼을 입력해 주세요.");
                String bonusNumber = Console.readLine();
                // 유효성 검증
                Validator.checkBonusNumber(bonusNumber, winningNumbers, "보너스 번호를 입력해주세요.");
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }
}
