package lotto.sevice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidService {
    public boolean isMoney(String money){
        try{
            int mon = Integer.parseInt(money);
            return mon % 1000 == 0;
        } catch (IllegalArgumentException e){
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
        List<String> list = Arrays.asList(nums);
        List<String> newList = list.stream().distinct().toList();
        return list.size() == newList.size();
    }

    public boolean isBonusNumber(String bonusNum, List<Integer> lotto){
        int num;
        try{
            num = Integer.parseInt(bonusNum);
        }catch(Exception e){
            return false;
        }
        for(int n : lotto){
            if(n == num){
                return false;
            }
        }

        return isRange(num);
    }

    public boolean isRange(int tmp){
        return tmp >= 0 && tmp <= 45;
    }
}
