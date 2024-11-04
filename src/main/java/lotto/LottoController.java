package lotto;

import java.util.*;

public class LottoController {
    private LottoModel model;
    private LottoView view;

    private int purchasePrice;
    private int numberOfPurchases;

    private List<Lotto> lottoNumbers;
    private List<Integer> winningNumbers;
    private List<Integer> countMatched = new LinkedList<>();

    private int bonusNumber;
    private int countHasBonusNumber;

    private double statistic;

    public LottoController(LottoModel model, LottoView view){
        this.model = model;
        this.view = view;
        this.statistic = 0;
        lottoNumbers = new LinkedList<>();
    }
    public void startLotto(){
        // 로또 정보 생성 및 저장
        setLottoInfo();

        // 로또 번호 매치
        matchNumbers();

        // 당첨 결과 출력 및 수익률 계산
        calculateStatistic();

        // 최종 결과
        view.finalResult(statistic);
    }
    public void setLottoInfo(){
        // 로또 구입 금액 입력 받고 적절한 입력인지 확인
        while(!setValidPurchasePrice());

        // 로또 번호 생성 및 출력
        numberOfPurchases = view.getNumberOfPurchase(purchasePrice);
        createLottoNumbers();
        view.printLottoNumbers(lottoNumbers);

        // 당첨 번호 입력 및 저장
        while(!setWinningNumber());

        // 보너스 번호 입력
        bonusNumber = view.getBonusNumber();
    }
    public boolean setValidPurchasePrice(){
        try {
            // 구매 금액 String으로 입력 받고 Integer로 형변환
            purchasePrice = Integer.parseInt(view.getPurchasePrice());
            return true;
        }catch (NumberFormatException e){
            // 숫자 이외의 문자가 포함 돼 있으면 NumberFormatException 발생
            System.out.println("\n[ERROR] 구매금액은 숫자로만 작성해야합니다.");
            return false;
        }
    }
    public void createLottoNumbers(){
        // 로또 번호 생성 및 리스트에 추가
        for(int i = 0; i < numberOfPurchases; i++){
            try {
                lottoNumbers.add(model.getLottoNumber());
            }catch (IllegalArgumentException e){
                // 로또 번호 개수가 6개가 아니거나 중복된 숫자가 포함 돼 있을 경우 예외 발생
                // i-- 후 로또 번호 재생성
                System.out.println(e.getMessage());
                i--;
            }
        }
    }
    public boolean setWinningNumber(){
        try{
            winningNumbers = new LinkedList<>();
            String numberString = view.getWinningNumbers();

            // 당첨 번호 리스트에 저장
            for(String n:numberString.split(",")){
                winningNumbers.add(Integer.parseInt(n));
            }
            // 객체 생성 하여 validate Number인지 확인
            Lotto winningLotto = new Lotto(winningNumbers);

            return true;
        }catch (NumberFormatException e){
            // 숫자와 콤마 이외의 문자를 입력했을 때 발생
            System.out.println("\n[ERROR] 당첨번호는 숫자와 콤마(,)로만 이루어져야합니다.");
            return false;
        }catch (IllegalArgumentException e){
            // 로또 번호 개수 및 중복 체크
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void matchNumbers(){
        // 구매 로또와 당첨 번호 매치
        // 몇 개 일치하는지 count 후 리스트에 count 저장
        Iterator<Lotto> iterator = lottoNumbers.listIterator();
        while(iterator.hasNext()){
            Lotto currentNumeberList = iterator.next();
            int count = currentNumeberList.getMatchedSize(winningNumbers);

            // 숫자가 5개 일치 + 보너스 번호 O
            if(count == 5 && currentNumeberList.hasBonusNumber(bonusNumber)){
                countHasBonusNumber++;
                continue;
            }
            countMatched.add(count);
        }
    }
    public void calculateStatistic(){
        HashMap<Integer, Integer> matchedResult = new HashMap<>();
        List<PrizeInfo> prizeList = List.of(
                PrizeInfo.THREE,
                PrizeInfo.FOUR,
                PrizeInfo.FIVE,
                PrizeInfo.SIX);

        for (PrizeInfo i : prizeList) {
            matchedResult.put(i.getCount(), Collections.frequency(countMatched, i.getCount()));
            statistic += matchedResult.get(i.getCount()) * i.getPrize();
        }
        statistic += countHasBonusNumber * PrizeInfo.FIVE_BONUS.getPrize();
        statistic = (statistic / purchasePrice) * 100;

        view.printMatchedResult(matchedResult, countHasBonusNumber);
    }
}
