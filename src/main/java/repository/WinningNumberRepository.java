package repository;

import constant.ErrorConst;
import java.util.ArrayList;
import java.util.List;
import utils.InputUtils;

public class WinningNumberRepository {

    private final List<Integer> winningNumbersRepository = new ArrayList<>();


    public void saveWinningLotto(int number) {
        winningNumbersRepository.add(number);
    }


    public List<Integer> findWinningLotto() {

        return new ArrayList<>(winningNumbersRepository);
    }


    public void makeWinningNumbers(String winningNumbersInput) {
        winningNumbersRepository.clear();
        String[] winningNumbers = winningNumbersInput.split(",", -1);
        for (String winningNumber : winningNumbers) {
            winningNumber = InputUtils.deleteBlank(winningNumber);
            int parsedwinningNumber;
            try {
                parsedwinningNumber = Integer.parseInt(winningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorConst.ERROR_PARSING_NUMBER);
            }
            saveWinningLotto(parsedwinningNumber);
        }

    }

}
