package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class WinningLottoInput {
    private static final int LOTTO_NUMBER_COUNT = 6; // 로또 번호는 6개
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static Set<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine().trim();
                String[] splitNumbers = input.split(",");

                Set<Integer> lottoNumbers = parseAndValidateNumbers(splitNumbers);

                return lottoNumbers;

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 형식으로 입력해주세요"); // 예외 발생 시 오류 메시지 출력
            }

        }
    }

    public static Integer getBonusNumber(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해주세요");

        while (true) {
            try {
                String input = Console.readLine().trim();

                int bonusNumber = Integer.parseInt(input);

                if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
                    System.out.println("[ERROR] 1~45의 숫자를 하나 입력해야 합니다.");
                    continue;
                }
                if (winningNumbers.contains(bonusNumber)) {
                    System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                    continue;
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식만 입력 가능합니다.");
            }
        }
    }

    private static Set<Integer> parseAndValidateNumbers(String[] splitNumbers) {
        if (splitNumbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야 합니다");
        }

        Set<Integer> lottoNumbers = new HashSet<>();

        for (String numStr : splitNumbers) {
            int number = parseNumber(numStr.trim());
            validateNumber(number);

            if (!lottoNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다");
            }
        }
        return lottoNumbers;
    }

    private static int parseNumber(String numStr) {
        try {
            return Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식만 입력 가능합니다");
        }
    }

    private static void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
        }
    }
}