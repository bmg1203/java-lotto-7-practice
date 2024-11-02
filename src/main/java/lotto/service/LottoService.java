package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.factory.LottoFactory;
import lotto.utility.Divider;
import lotto.utility.Parser;
import lotto.utility.RandomGenerator;
import lotto.validation.Validator;

public class LottoService {
    private static final String FIXED_DELIMITER = ",";


    public int isValidNumber(String inputCost) {
        isBlank(inputCost);
        isPositiveNumber(inputCost);
        int parsedCost = parseStringToInt(inputCost);
        isDivisibleByThousand(parsedCost);

        return parsedCost;
    }

    private void isBlank(String inputCost) {
        Validator.isBlank(inputCost);
    }

    private void isPositiveNumber(String inputCost) {
        Validator.isPositiveNumber(inputCost);
    }

    private int parseStringToInt(String inputCost) {
        return Parser.parseStringToInt(inputCost);
    }

    private void isDivisibleByThousand(int parsedPurchaseAmount) {
        Validator.isDivisibleByThousand(parsedPurchaseAmount);
    }

    public int divideInputByLottoPrice(int parsedPurchaseAmount) {
        return Divider.divideInputByLottoPrice(parsedPurchaseAmount);
    }

    public LottoCollection generateLottoCollection(int purchasedLottoCount) {
        LottoCollection lottoCollection = generateLottoCollection();

        for (int i = 0; i < purchasedLottoCount; i++) {
            Lotto oneLotto = generateOneLottoObject();
            lottoCollection.addLotto(oneLotto);
        }
        return lottoCollection;
    }

    public List<Integer> generateOneSetRandomNumber() {
        return RandomGenerator.makeRandomNumber();
    }

    public Lotto generateOneLottoObject() {
        List<Integer> randomNumber = generateOneSetRandomNumber();
        return LottoFactory.createLotto(randomNumber);
    }

    public LottoCollection generateLottoCollection() {
        return LottoFactory.createLottoCollection();
    }

    public List<Lotto> prepareCollectionForPrint(LottoCollection lottoCollection) {
        List<Lotto> lottos = lottoCollection.getAllLotto();
        for (Lotto lotto : lottos) {
            Collections.sort(lotto.getNumbers());
        }
        return lottos;
    }

    // split 전, 모든 문자열이 비어있는지 콤마(,)와 숫자로만 이루어져있는지 검증
    public void validateInputWinNumber(String winningNumber) {
        Validator.isBlank(winningNumber);
        Validator.isValidNumberAndDelimiter(winningNumber);
    }

    public String[] splitWinningNumber(String winningNumber) {
        String[] splitWinningNumber = winningNumber.split(FIXED_DELIMITER);
        return splitWinningNumber;
    }

    /* split 후, 검증
     * 숫자가 비어있는지x
     * 1~45 사이의 숫자로만 되어있는지x
     * 6개의 숫자인지
     * 중복된 숫자가 있는지 확인*/
    public List<Integer> validateSplitWinNumber(String[] splitWinningNumber) {
        List<Integer> validWinNumbers = new ArrayList<>();

        Validator.isNumberSixSize(splitWinningNumber);

        for (String winningNumber : splitWinningNumber) {
            Validator.isBlank(winningNumber);
            int parsedWinNumber = parseStringToInt(winningNumber);
            Validator.isBetweenOneAndFortyFive(parsedWinNumber);
            Validator.isDuplicateNumber(parsedWinNumber);

            validWinNumbers.add(parsedWinNumber);
        }
        return validWinNumbers;
    }


}
