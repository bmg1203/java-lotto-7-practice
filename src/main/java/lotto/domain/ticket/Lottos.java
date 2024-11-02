package lotto.domain.ticket;

import static java.util.Collections.unmodifiableList;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = unmodifiableList(lottos);
    }

    public static Lottos of(List<Lotto> lottos) {
        validate(lottos);
        return new Lottos(lottos);
    }

    private static void validate(List<Lotto> lottos) {
        validateNotNull(lottos);
        validateNotEmpty(lottos);
    }

    private static void validateNotNull(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException("[ERROR] 로또 목록은 null일 수 없습니다.");
        }
    }

    private static void validateNotEmpty(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 목록은 비어있을 수 없습니다.");
        }
    }

}
