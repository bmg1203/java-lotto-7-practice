package lotto.domain.lotto;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.dto.GetLottosDto;
import lotto.global.util.NumberGenerator;

public class Lottos {
    private final NumberGenerator lottoNumberGenerator;
    private final List<Lotto> lottos;

    private Lottos(final int count, final NumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottos = createLottos(count);
    }

    public static Lottos of(final int count, final NumberGenerator lottoNumberGenerator) {
        return new Lottos(count, lottoNumberGenerator);
    }

    private List<Lotto> createLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.from(lottoNumberGenerator.generate()))
                .toList();
    }

    public GetLottosDto getLottos() {
        return new GetLottosDto(lottos.stream()
                .map(Lotto::getLotto)
                .toList());
    }
}
