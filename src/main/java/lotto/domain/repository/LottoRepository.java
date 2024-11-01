package lotto.domain.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private final List<Lotto> lottos = new ArrayList<>();

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
