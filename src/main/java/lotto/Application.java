package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.*;

public class Application {
    private static int amountToPurchase;
    private static int numOfLotto;
    private static List<Lotto> lottos;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;
    private static Map<WinningCount, Integer>  lottoCountByWinning;
    public static void main(String[] args) {
        readUserInput();

        initLottoCountByWinning();

        for (int i = 0; i < numOfLotto; i++) {
            Lotto lotto = lottos.get(i);

            int numberOfWinningNumber = lotto.countWinningNumber(winningNumbers);
            boolean isBonusMatched = lotto.checkBonusNumberMatch(bonusNumber);

            WinningCount winningCount = WinningCount.from(numberOfWinningNumber, isBonusMatched);
            if(winningCount == null) continue;

            lottoCountByWinning.put(winningCount, lottoCountByWinning.get(winningCount) + 1);
        }

        double rateOfGain = calculateRateOfGain();
        printResult(rateOfGain);
    }

    public static void readUserInput(){
        System.out.println("구입금액을 입력해 주세요.");
        amountToPurchase = readAmountToPurchase();

        numOfLotto = calcNumOfLottos();
        System.out.println(numOfLotto + "개를 구매했습니다.");

        lottos = createLottos();
        lottos.forEach(System.out::println);

        boolean isValidInput = false;

        while(!isValidInput){
            try {
                System.out.println("당첨 번호를 입력해 주새요.");
                winningNumbers = readWinningNumbers();
                isValidInput = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        isValidInput = false;

        while(!isValidInput){
            try{
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = readBonusNumber();
                isValidInput = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readAmountToPurchase(){
        String input = Console.readLine();
        return (Integer.parseInt(input) / 1000) * 1000;
    }

    private static int calcNumOfLottos(){
        return numOfLotto = amountToPurchase / 1000;
    }

    private static List<Lotto> createLottos(){
        lottos = new ArrayList<>();

        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(uniqueNumbers);
            lottos.add(new Lotto(uniqueNumbers));
        }

        return lottos;
    }

    private static List<Integer> readWinningNumbers(){
        String input = Console.readLine();

        List<Integer> result = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        result.forEach(Application::validateLottoNumber);


        return result;
    }

    private static int readBonusNumber(){
        int bonusNum = Integer.parseInt(Console.readLine());

        validateLottoNumber(bonusNum);

        return bonusNum;
    }

    private static void validateLottoNumber(int num){
        if (num < 1 || num > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void initLottoCountByWinning(){
        lottoCountByWinning = new HashMap<>();

        for(WinningCount winningCount : WinningCount.values()){
            lottoCountByWinning.put(winningCount, 0);
        }
    }

    private static double calculateRateOfGain(){
        double sumOfGain = 0;

        for(WinningCount winningCount : lottoCountByWinning.keySet()){
            sumOfGain = winningCount.getAmountToWin() * lottoCountByWinning.get(winningCount);
        }

        return Math.round(sumOfGain / amountToPurchase * 100.0) / 100.0;
    }

    private static void printResult(double rateOfGain){
        System.out.println("당첨 통계");
        System.out.println("---");

        String result;
        NumberFormat formatter = NumberFormat.getInstance();

        for (WinningCount winningCount:lottoCountByWinning.keySet()){
            result = "";

            result += winningCount.getCountOfWinningNumber() + "개 일치";

            if(winningCount.isBonusMatched()){
                result += ", 보너스 볼 일치 ";
            }

            result += "(" + formatter.format(winningCount.getAmountToWin()).replace(",", ", ") + "원)";
            result += " - " + lottoCountByWinning.get(winningCount) + "개";
            System.out.println(result);
        }

        System.out.println("총 수익률은" + rateOfGain + "%입니다.");
    }
}
