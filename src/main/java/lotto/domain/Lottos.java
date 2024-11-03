package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos (List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Integer size() {
        return lottos.size();
    }
}
