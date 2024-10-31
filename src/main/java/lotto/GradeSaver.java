package lotto;

import java.util.ArrayList;
import java.util.List;

public class GradeSaver {
    private Integer third = 0;
    private Integer fourth = 0;
    private Integer fifth = 0;
    private Integer fifthBonus = 0;
    private Integer sixth = 0;

    public GradeSaver sumUpGrades(List<MyResult> resultList){
        for(MyResult result : resultList){
            if(result.getMatches() == 3) this.third++;
            else if(result.getMatches() == 4) this.fourth++;
            else if(result.getMatches() == 5 && result.getBonusPoint()) this.fifth++;
            else if(result.getMatches() == 5 && !result.getBonusPoint()) this.sixth++;
            else if(result.getMatches() == 6) this.sixth++;
        }
        return this;
    }

    public static List<MyResult> saveMyGrades(List<Lotto> lottoList, Lotto answer, Integer bonus){
        List<MyResult> resultList = new ArrayList<MyResult>();
        for(int i = 0; i < lottoList.size(); i++){
            MyResult gradedLotto = Lotto.gradeLotto(answer, lottoList.get(i), bonus);
            resultList.add(gradedLotto);
        }
        return resultList;
    }

    public Integer getThird() {
        return third;
    }
    public Integer getFourth() {
        return fourth;
    }
    public Integer getFifth() {
        return fifth;
    }
    public Integer getFifthBonus() {
        return fifthBonus;
    }
    public Integer getSixth() {
        return sixth;
    }
}
