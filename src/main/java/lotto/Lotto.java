package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int MAX_NUM = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    public static void isValidateNumber(int num){
        if(num<=0 || num>Lotto.MAX_NUM){
            throw new IllegalArgumentException("로또 번호는 1부터 "+Lotto.MAX_NUM+" 사이의 숫자여야 합니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        numbers.forEach(Lotto::isValidateNumber);

        for(int i=1; i<numbers.size(); i++){
            if(Objects.equals(numbers.get(i - 1), numbers.get(i))){
                throw new IllegalArgumentException("로또 번호는 중복이 있으면 안됩니다.");
            }
        }
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    public boolean hasValue(int num){
        return numbers.contains(num);
    }

    public int equalSize(Lotto lotto){
        int size = 0;
        for(Integer num : numbers){
            if(lotto.hasValue(num))
                size++;
        }
        return size;
    }
}
