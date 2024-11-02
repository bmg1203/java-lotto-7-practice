package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberInputHandler extends InputHandler{
    private String winningNumber;

    public WinningNumberInputHandler() {
        boolean isValid = false;

        while(!isValid){
            System.out.println("당첨 번호를 입력해 주세요.");
            this.winningNumber = camp.nextstep.edu.missionutils.Console.readLine();
            try{
                validateInput();
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    @Override
    public void validateInput() {
        throwExceptionWhenInputIsInvalid();
        throwExceptionWhenInputIsNotInRange1To45();
    }

    public String[] splitNumbers(String input) {
        return input.split(",");
    }

    public List<Integer> stringInputParseInteger(String input) {
        String[] numbers = splitNumbers(input);
        List<Integer> lottoWinningNumbers = new ArrayList<>();
        for(String number:numbers) {
            lottoWinningNumbers.add(Integer.parseInt(number));
        }
        return lottoWinningNumbers;
    }

    private void throwExceptionWhenInputIsInvalid() {
        if(!Validation.isValidWinningNumber(winningNumber)){
            throwIllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    private void throwExceptionWhenInputIsNotInRange1To45() {
        if(!Validation.isInRange1To45(stringInputParseInteger(winningNumber))){
            throwIllegalArgumentException("당첨 번호의 숫자는 1부터 45까지의 범위안에서 입력해 주세요.");
        }
    }
}
