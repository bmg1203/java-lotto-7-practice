/*
 * 클래스 이름 WinningNumber
 *
 * 버전 정보 V1
 *
 * 날짜 10월 31일
 *
 * 저작권 주의
 */
package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WinningNumber {
    private final List<Integer> winningNumbers;

    public WinningNumber(String winningNumber) {
        List<Integer> list;
        try {
            String[] split = winningNumber.split(",");
            Stream<String> stream = Arrays.stream(split);
            Stream<Integer> integerStream = stream.map(Integer::parseInt);
            list = integerStream.toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.READ_NUMBER_ERROR_MESSAGE);
        }
        validateLotto(list);
        winningNumbers = list;
    }

    private static void validateLotto(List<Integer> list) {
        try {
            new Lotto(list);
        }catch (Exception exception) {
            throw exception;
        }
    }

    public List<Integer> getList() {
        return winningNumbers;
    }
}
