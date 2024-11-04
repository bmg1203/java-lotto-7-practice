package repository;

import java.util.ArrayList;
import java.util.List;

import lotto.PurchasedLotto;
import observer.Observer;

public class PurchasedLottoRepository {

    private final List<Observer> myLottoRepository=new ArrayList<>();

    public void saveMyLotto(PurchasedLotto lotto){
        myLottoRepository.add(lotto);
    }

    public List<Observer> findMyAllLotto(){
        return new ArrayList<>(myLottoRepository);
    }


}
