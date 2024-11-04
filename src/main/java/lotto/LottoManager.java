package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoPrize;
import lotto.validator.LottoValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LottoManager {

    //구매할 로또 갯수
    private int purchaseAmount;
    //추후 수익률 계산을 위한 변수
    private int purchasePrice;
    private int bonusNum;
    private int totalEarningSum = 0;
    private Lotto winningLotto;
    private List<Lotto> lottoList = new ArrayList<>();

    public void play(){
        setPurchaseAmount();
        setLotto();
        setWinningNumber();
        setBonusNumber();
        compareLottoList();
        printResult();
        printProfit();
        Console.close();
    }

    public void setPurchaseAmount(){
        while (!getPurchaseAmount()){
        }
    }

    public void setLotto(){
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
        for(int i = 0; i < purchaseAmount; i++){
            putRandomLotto();
        }
    }

    public void setWinningNumber(){
        while (!getWinningNumbers()) {
        }
    }

    public void setBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine().trim();

        while (!convertBonusNumToInteger(userInput)){
            System.out.println("\n보너스 번호를 입력해 주세요.");
            userInput = Console.readLine().trim();
        }
    }

    public void compareLottoList(){
        for (Lotto lotto : lottoList) {
            int compareLottoNumber = compareLotto(lotto);
            increaseEachMatchCount(compareLottoNumber, LottoValidator.findBonus(lotto.getNumbers(), bonusNum));
        }
    }

    public int compareLotto(Lotto lotto){
        Set<Integer> winLotto = new HashSet<>(winningLotto.getNumbers());
        Set<Integer> eachLotto = new HashSet<>(lotto.getNumbers());
        winLotto.retainAll(eachLotto);
        return winLotto.size();
    }

    public void printResult(){
        System.out.println("\n당첨 통계\n---");
        for (LottoPrize prize : LottoPrize.values()) {
            totalEarningSum += prize.getPrizeMoney() * prize.getEachMatchCount();
            String formatPrice = String.format("%,d", prize.getPrizeMoney());
            System.out.println(prize.getDescription() +" (" + formatPrice + "원) - " + prize.getEachMatchCount() + "개");
        }
    }

    public void printProfit(){
        System.out.println("총 수익률은 " + calculateProfit() +"%입니다.");
    }

    private boolean convertBonusNumToInteger(String userInput) {
        try {
            bonusNum = LottoValidator.stringToInt(userInput);
            LottoValidator.checkRangeLotto(bonusNum);
            LottoValidator.checkDuplicate(winningLotto.getNumbers(), bonusNum);
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine().trim();
        String[] winningNumber = userInput.split(",\\s*");
        for (String eachNum : winningNumber) {
            convertWinningNumToInteger(eachNum.trim(), winningNumbers);
        }
        if (setWinningLotto(winningNumbers)) {
            return true;
        }
        return false;
    }

    private boolean setWinningLotto(List<Integer> winningNumbers) {
        try {
            winningLotto = new Lotto(winningNumbers);
            return true;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void convertWinningNumToInteger(String eachNum, List<Integer> winningNumbers) {
        try {
            int eachWinningNum = LottoValidator.stringToInt(eachNum);
            LottoValidator.checkRangeLotto(eachWinningNum);
            winningNumbers.add(eachWinningNum);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private boolean getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine().trim();

        return processInput(userInput);
    }

    private boolean processInput(String userInput){
        try {
            int convertAmount = LottoValidator.stringToInt(userInput);
            return validateInput(convertAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validateInput(int convertAmount) {
        if (LottoValidator.unitValidator(convertAmount)) {
            purchasePrice = convertAmount;
            purchaseAmount = convertAmount / 1000;
            return true;
        }
        return false;
    }

    private void putRandomLotto(){
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbers);
        //각 로또의 모든 숫자들 출력
        lotto.printLotto();
        lottoList.add(lotto);
    }

    private void increaseEachMatchCount(int matchCount, boolean matchBonus){
        LottoPrize prize = LottoPrize.checkValue(matchCount, matchBonus);
        if(prize != null){
            prize.increaseEachMatchCount();
        }
    }

    double calculateProfit() {
        if (purchasePrice == 0) {
            throw new IllegalArgumentException("[Error] 구매 금액은 0이 될 수 없습니다.");
        }
        double profitRate = ((double) totalEarningSum / purchasePrice) * 100;
        BigDecimal roundedProfitRate = new BigDecimal(profitRate).setScale(1, RoundingMode.HALF_UP); // 소수점 첫째 자리에서 반올림
        return roundedProfitRate.doubleValue();
    }

    //테스트를 위한 설정 메서드
    void setPurchaseAmountForTest(int purchaseAmountForTest) {
        this.purchaseAmount = purchaseAmountForTest;
    }

    void setPurchasePriceForTest(int purchasePriceForTest) {
        this.purchasePrice = purchasePriceForTest;
    }

    void setTotalEarningSumForTest(int totalEarningSumForTest){
        this.totalEarningSum = totalEarningSumForTest;
    }

    void setWinningLottoForTest(Lotto winningLottoForTest) {
        this.winningLotto = winningLottoForTest;
    }

    //테스트를 위한 조회 메서드
    public List<Lotto> getLottoList() {
        //unmodifiableList를 통해 오직 조회만 가능하도록
        return Collections.unmodifiableList(lottoList);
    }

}
