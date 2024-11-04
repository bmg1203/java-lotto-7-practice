package lotto.domain;

public enum WinningRank {
    LOSE(0,0,false),
    FIFTHPLACE(3,5000,false),
    FOURTHPLACE(4,50000,false),
    THIRDPLACE(5,1500000,false),
    SECONDPLACE(5,30000000,true),
    FIRSTPLACE(6,2000000000,false);

    private final int numberOfCorrectNumber;
    private final int prizeMoneyAmount;

    public boolean isBonusNumberCorrect() {
        return isBonusNumberCorrect;
    }

    private final boolean isBonusNumberCorrect;

    WinningRank(int numberOfCorrectNumber, int prizeMoneyAmount, boolean isBonusNumberCorrect){
        this.numberOfCorrectNumber = numberOfCorrectNumber;
        this.prizeMoneyAmount = prizeMoneyAmount;
        this.isBonusNumberCorrect = isBonusNumberCorrect;
    }

    public static WinningRank calculateLottoRank(int numberOfCorrectNumber, boolean isBonusNumberCorrect){
        WinningRank lottoWinningRank = LOSE;
        for(WinningRank winningRank: WinningRank.values()){
            if(winningRank.getnumberOfCorrectNumber() == numberOfCorrectNumber){
                if(winningRank.getnumberOfCorrectNumber() == 5 && winningRank.isBonusNumberCorrect() == isBonusNumberCorrect)
                    lottoWinningRank = winningRank;
                else
                    lottoWinningRank = winningRank;
            }
        }
        return lottoWinningRank;
    }


    public int getnumberOfCorrectNumber() {
        return numberOfCorrectNumber;
    }

    public int getPrizeMoneyAmount(){
        return prizeMoneyAmount;
    }
}
