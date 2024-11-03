package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoGrade> convertGrades(TargetLotto targetLotto) {
        return lottos.stream()
                .map(lotto -> lotto.match(targetLotto))
                .toList();
    }
}
