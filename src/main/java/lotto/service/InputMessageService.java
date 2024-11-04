package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.validation.EnterBonusNumberValidation;
import lotto.validation.EnterWinningNumberValidation;
import lotto.validation.PurchaseAmountValidation;
import lotto.view.InputMessageView;

public class InputMessageService {

  private final InputMessageView inputMessageView;
  private final PurchaseAmountValidation purchaseAmountValidation;
  private final EnterWinningNumberValidation enterWinningNumberValidation;
  private final EnterBonusNumberValidation enterBonusNumberValidation;

  public InputMessageService(InputMessageView inputMessageView,
      PurchaseAmountValidation purchaseAmountValidation,
      EnterWinningNumberValidation enterWinningNumberValidation,
      EnterBonusNumberValidation enterBonusNumberValidation) {
    this.inputMessageView = inputMessageView;
    this.purchaseAmountValidation = purchaseAmountValidation;
    this.enterWinningNumberValidation = enterWinningNumberValidation;
    this.enterBonusNumberValidation = enterBonusNumberValidation;
  }

  public Long enterPurchaseAmountAndValidation() {
    String purchaseAmount = "";
    boolean isValid = false;
    while (!isValid) {
      purchaseAmount = inputMessageView.enterPurchaseAmount();
      isValid = purchaseAmountValidation.validatePurchaseAmount(purchaseAmount);

    }
    return Long.parseLong(purchaseAmount);
  }


  public List<Integer> enterWinningNumberAndValidation() {
    boolean isValid = false;
    List<Integer> enterNumbers = null;
    while (!isValid) {
      try {
        enterNumbers = new ArrayList<>();
        String[] splitResult = inputMessageView.enterWinningNumber().split(",");
        for (int i = 0; i < splitResult.length; i++) {
          enterNumbers.add(Integer.parseInt(splitResult[i]));
        }
        isValid = enterWinningNumberValidation.validateEnterWinningNumber(enterNumbers);
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 로또 번호는 1~45의 숫자여야 합니다.");
      }
    }
    return enterNumbers;
  }

  public int winningNumbersAddBonusNumberAndValidation(List<Integer> winningNumbers) {
    boolean isValid = false;
    String bonusNumber = "";
    while (!isValid) {
      bonusNumber = inputMessageView.enterBonusNumber();
      isValid = enterBonusNumberValidation.validateEnterBonusNumber(winningNumbers, bonusNumber);
    }
    return Integer.parseInt(bonusNumber);
  }

}
