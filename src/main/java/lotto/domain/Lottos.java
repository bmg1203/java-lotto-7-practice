package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoGrade> convertGrades(Lotto target, int bonus) {
        return lottos.stream()
                .map(lotto -> lotto.match(target, bonus))
                .toList();
    }
}
