package lotto.sevice;

import java.security.spec.ECField;

public class InputValidService {
    public boolean isMoney(String money){
        try{
            int mon = Integer.parseInt(money);
            return mon % 1000 == 0;
        } catch (Exception e){
            return false;
        }
    }

    public boolean isWinNumbers(String numbers){
        String[] nums = numbers.split(",");
        for(String n : nums){
            n = n.trim();
            int tmp;
            try{
                tmp = Integer.parseInt(n);
            }catch (Exception e){
                return false;
            }
            if(!isRange(tmp)){
                return false;
            }
        }
        return true;
    }

    public boolean isRange(int tmp){
        return tmp >= 0 && tmp <= 45;
    }
}
