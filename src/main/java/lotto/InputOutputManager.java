package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputOutputManager {
    private List<Integer> lottoNumber = new ArrayList<>();
    private List<Lotto> LottoNumbers = new ArrayList<>();
    private Purchase purchase;
    private Lotto lotto;
    private BonusNumber bonusNumber;
    private int[] rank = new int[5];

    public InputOutputManager() {
        // TODO: 프로그램 구현
        savePurchaseAmount();
        printPurchaseLottoNumbers();
        saveLottoNumbers();
        saveBonusNumber();
        getRank();
        printStatistic();
        printEarningsRate();
    }

    private void savePurchaseAmount() {
        while(true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                purchase = new Purchase(Console.readLine());
                return;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private void printPurchaseLottoNumbers() {
        System.out.println();
        LottoNumbers = purchase.getLottoNumbers();
        System.out.println(LottoNumbers.size() + "개를 구매했습니다.");
        for(Lotto lotto : LottoNumbers) {
            System.out.println(lotto.getLottoNumber());
        }
    }

    private String getLottoNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator(input);
        // 입력된 문자열을 정수 리스트로 변환
        lottoNumber = Arrays.stream(input.split(","))
//                .map(String::trim) // 공백 제거
                .map(Integer::parseInt) // String을 Integer로 변환
                .collect(Collectors.toList());
        return input;
    }

    private void saveLottoNumbers() {
        while(true){
            try {
                String input = getLottoNumbers();
                lotto = new Lotto(lottoNumber);
                return;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveBonusNumber() {
        while(true) {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                bonusNumber = new BonusNumber(Console.readLine(), lottoNumber);
                return;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getRank() {
        for(Lotto numbers : LottoNumbers){
            boolean flag = false;
            int count = (int) numbers.getLottoNumber().stream()
                    .filter(lottoNumber::contains) // list2에 포함된 요소만 필터링
                    .count();
            checkRank(numbers.getLottoNumber(), count);
        }
    }

    private void checkRank(List<Integer> getLottoNumber, int count) {
        if (count == 3) { rank[0] += 1; return; }
        if (count == 4) { rank[1] += 1; return; }
        if (count == 5) {
            if (getLottoNumber.contains(bonusNumber.getBonusNumber())) {
                rank[3] += 1;
                return;
            }
            rank[2] += 1;
            return;
        }
        if (count == 6) rank[4] += 1;
    }

    private void printStatistic() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rank[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + rank[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rank[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rank[4] + "개");
    }

    private void printEarningsRate() {
        float EARNINGS = 5000 * rank[0] + 50000 * rank[1] + 1500000 * rank[2] + 30000000 * rank[3] + 2000000000 * rank[4];
        float EARNINGS_RATE = (EARNINGS / purchase.getPurchaseAmount()) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", EARNINGS_RATE);
    }
}
