package lotto.common;

import lotto.LottoApplication;
import lotto.application.CalculateProfitUseCase;
import lotto.application.LottoResultUseCase;
import lotto.application.FacadeLottoUseCase;
import lotto.application.PurchaseLottoUseCase;
import lotto.application.RetrieveLottoUseCase;
import lotto.application.service.CalculateProfitService;
import lotto.application.service.FacadeLottoService;
import lotto.domain.LottoMatcher;
import lotto.application.service.LottoResultService;
import lotto.application.service.PurchaseLottoService;
import lotto.application.service.RetrieveLottoService;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.repository.InMemoryLottoRepository;
import lotto.domain.repository.InMemoryWinLottoRepository;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.WinLottoRepository;
import lotto.domain.repository.WinResultHistory;
import lotto.view.ApplicationConsoleView;
import lotto.view.ApplicationView;
import lotto.view.converter.LottoMessageParser;
import lotto.view.converter.MessageParser;

public final class LottoConfig {

    private static final LottoConfig INSTANCE = new LottoConfig();

    private LottoConfig() {

    }

    public static LottoConfig getInstance() {
        return INSTANCE;
    }

    public LottoApplication lottoApplication() {
        return new LottoApplication(applicationView(), messageConverter(), lottoUseCase());
    }

    private ApplicationView applicationView() {
        return new ApplicationConsoleView();
    }

    private MessageParser<Lotto> messageConverter() {
        return new LottoMessageParser();
    }

    private FacadeLottoUseCase lottoUseCase() {
        return new FacadeLottoService(purchaseLottoUseCase(), retrieveLottoUseCase(), lottoResultUseCase(), calculateProfitUseCase());
    }

    private PurchaseLottoUseCase purchaseLottoUseCase() {
        return new PurchaseLottoService(new LottoFactory(), lottoRepository());
    }

    private RetrieveLottoUseCase retrieveLottoUseCase() {
        return new RetrieveLottoService(lottoRepository());
    }

    private LottoResultUseCase lottoResultUseCase() {
        return new LottoResultService(winLottoRepository(), WinResultHistory.getInstance(), lottoRepository(), new LottoMatcher());
    }

    private CalculateProfitUseCase calculateProfitUseCase() {
        return new CalculateProfitService(lottoRepository(), WinResultHistory.getInstance());
    }

    private LottoRepository lottoRepository() {
        return InMemoryLottoRepository.getInstance();
    }

    private WinLottoRepository winLottoRepository() {
        return InMemoryWinLottoRepository.getInstance();
    }
}
