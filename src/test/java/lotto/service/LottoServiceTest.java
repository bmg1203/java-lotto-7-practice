package lotto.service;

import lotto.generator.LottoGenerator;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.LottoConstants.END_INCLUSIVE;
import static lotto.constants.LottoConstants.START_INCLUSIVE;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private LottoGenerator lottoGenerator;
    private LottoService lottoService;
    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
        lottoService = new LottoService(lottoGenerator);
    }

    @Test
    void 로또_5장_생성() {
        int amount = 5000;
        int expectedTicketCount = 5;

        List<Lotto> actualLottos = lottoService.generateLottos(amount);

        assertEquals(expectedTicketCount, actualLottos.size());

        assertTrue(actualLottos.stream()
                .allMatch(lotto -> lotto.getNumbers().size() == 6));

        assertTrue(actualLottos.stream()
                .flatMap(lotto -> lotto.getNumbers().stream())
                .allMatch(num -> num >= START_INCLUSIVE && num <= END_INCLUSIVE));
    }
}