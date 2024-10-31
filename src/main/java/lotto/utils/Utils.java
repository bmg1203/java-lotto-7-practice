package lotto.utils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {

    //숫자 인지 확인
    public static boolean isDigitOnly (String input) {
        return input.matches("\\d+");
    }

    public static boolean isInRange (BigDecimal min, BigDecimal max, BigDecimal value) {
        return (value.compareTo(min) >= 0 && value.compareTo(max) <= 0);
    }

    //문자열을 int로 바꾸는 메서드
    public static int stringToInteger (String input) {
        return Integer.parseInt(input);
    }

    //입력을 숫자로 바꾸는 메서드
    public static BigDecimal stringToNumber (String input) {
        return new BigDecimal(input);
    }

    public static boolean isDivisibleByThousand (int num) {
        return (num % 1000 == 0);
    }

    public static boolean allElementsAreDigits (String[] input) {
        for (String target : input) {
            if (!Utils.isDigitOnly(target)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSizeEqual (String[] input, int size) {
        return input.length == size;
    }

    public static boolean areAllNumbersValidRange (BigDecimal min, BigDecimal max, List<BigDecimal> numbers) {
        for (BigDecimal number : numbers) {
            if (!Utils.isInRange(min, max, number)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicateNumber (List<BigDecimal> numbers) {
        Set<BigDecimal> uniqueNumbers = new HashSet<>();
        for (BigDecimal number : numbers) {
            if (!uniqueNumbers.add(number)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberInList(List<Integer> numbers, int target) {
        for (Integer number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }
}