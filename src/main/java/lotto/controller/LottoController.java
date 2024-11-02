package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Amount;
import lotto.model.LottoPublisher;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.ValidationManager;
import utils.TypeConverter;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final ValidationManager validationManager;
    //private final LottoPublisher lottoPublisher;

    public LottoController(InputView inputView, OutputView outputView, ValidationManager validationManager) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.validationManager = validationManager;
    }

    public void play() {
        int validAmount = handleAmountInputError();
        List<Integer> validLottoNumbers = handleLottoNumberInputError();
        int validBonusNumber = handleBonusInputError();

    }

    public int handleAmountInputError() { //얘네들이 15줄을 넘는 이유는 기능이 3가지임 인풋 아웃풋 컨트롤 , 타당성 체크, 형변환
        boolean validInput = false;
        Amount amount ;

        while (!validInput) {
            try {
                String input = inputView.readInput(Amount.getRequestMessage());
                isValidAmountInput(input);
                amount = new Amount(TypeConverter.ToNumber(input)); //1000으로 나누어떨어지는 지 확인 후 생성
                return amount.getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }

    public boolean isValidAmountInput(String input) {
        validationManager.isNotEmptyInput(input);
        return validationManager.isNumber(input);
    }

    public List<Integer> handleLottoNumberInputError() {
        boolean validInput = false;
        Lotto lotto;

        while (!validInput) {
            try {
                String lottoInput = inputView.readInput(Lotto.getRequestMessage());
                validationManager.isNumbersDividedByComma(lottoInput); //정수와 쉼표로 이루어져있는지 확인
                lotto = new Lotto(TypeConverter.ToNumberList(lottoInput));//6자 이상인지 범위는 (1-45)인지 확인후 객체 생성
                return lotto.getLottoNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new ArrayList<>();
    }

    public int handleBonusInputError() {
        boolean validInput = false;
        Bonus bonus;

        while (!validInput) {
            try {
                String input = inputView.readInput(Bonus.getRequestMessage());
                validationManager.isNotEmptyInput(input);
                validationManager.isNumber(input);
                bonus = new Bonus(TypeConverter.ToNumber(input));
                return bonus.getBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
}
