package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import lotto.Constants.LottoRule;

public class Application {
    public static List<Integer> selectRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange( LottoRule.MIN_NUMBER.getNumber(), LottoRule.MAX_NUMBER.getNumber(), LottoRule.NUM_AMOUNT.getNumber() );
    }
    public static Lotto publishLotto(){
        return new Lotto( selectRandomNumbers() );
    }

    public static int checkAmount( int price ){
        if( price < 1000 || price % 1000 != 0 ) throw new IllegalArgumentException();
        return price / 1000;
    }

    public static List<Integer> setWinNumber( String input ){
        StringTokenizer tokenizer = new StringTokenizer( input, "," );
        List<Integer> winNumbers = new ArrayList<Integer>();
        while( tokenizer.hasMoreTokens() )  winNumbers.add( Integer.parseInt( tokenizer.nextToken() ) );
        if( winNumbers.size() != 6 ) throw new IllegalArgumentException();
        return winNumbers;
    }

    public static int setBonusNumber( String input ){
        try{
            int bounusNumber = Integer.parseInt( input );
            return bounusNumber;
        } catch( Exception e ){
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
