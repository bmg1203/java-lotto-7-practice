package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoNumbers {

    public LottoNumbers() {
    }

    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;


    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }


    public static Lotto makeLotto(){
        List<Integer> lottoNumbers = LottoNumbers.generateLottoNumbers();
        System.out.println(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static List<Lotto> makeLottoList(int gameNumber){
        System.out.println(gameNumber+"개를 구매했습니다.");
        ArrayList<Lotto> lottoList = new ArrayList<>();
        for(int i=1; i<=gameNumber; i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

}
