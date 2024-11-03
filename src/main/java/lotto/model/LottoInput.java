package lotto.model;

import lotto.errors.BonusNumberErrors;
import lotto.errors.PurchaseAmountErrors;
import lotto.errors.WinningNumbersErrors;

import java.util.*;
import java.util.stream.Collectors;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public Integer getLottoPurchaseAmount() {
        // 로또 구입 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = scanner.next();

        PurchaseAmountErrors errorHandler = new PurchaseAmountErrors();
        errorHandler.errorCheck(purchaseAmount);

        Integer lottoAmount = Integer.parseInt(purchaseAmount) / 1000;
        System.out.println(lottoAmount+"개를 구매했습니다.");

        return lottoAmount;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        String winningNumbersInput = scanner.nextLine();
        List<Integer> winningNumbers = new ArrayList<>();

        WinningNumbersErrors errorHandler = new WinningNumbersErrors();
        errorHandler.errorCheck(winningNumbers);

        winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        Collections.sort(winningNumbers);

        return winningNumbers;
    }

    public Integer inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = scanner.nextInt();

        BonusNumberErrors errorHandler = new BonusNumberErrors();
        errorHandler.errorCheck(bonusNumber, winningNumbers);

        return bonusNumber;
    }

}
