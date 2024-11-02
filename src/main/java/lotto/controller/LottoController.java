package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchaseLottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoGameDto;
import lotto.service.LottoGameService;
import lotto.viewHandler.api.dto.input.BonusNumberDto;
import lotto.viewHandler.api.dto.input.MoneyDto;
import lotto.viewHandler.api.dto.input.WinningLottoNumbersDto;

public class LottoController {
    private final LottoGameService lottoGameService;

    public LottoController(LottoGameService lottoGameService) {
        this.lottoGameService = lottoGameService;
    }

    public PurchaseLottos purchaseLotto(MoneyDto dto) {
        return PurchaseLottos.of(dto.getMoney());
    }

    public Lotto createWinningLotto(WinningLottoNumbersDto winningLottoNumbersDto) {
        return new Lotto(winningLottoNumbersDto.getNumbers());
    }

    public WinningLotto createWinningLottoDto(Lotto winningLotto, BonusNumberDto bonusNumberdto) {
        Integer bonusNumber = bonusNumberdto.getNumber();
        return WinningLotto.of(winningLotto, bonusNumber);
    }

    public LottoGameDto createGameDto(PurchaseLottos purchaseLottos, WinningLotto winningLotto) {
        return new LottoGameDto(purchaseLottos, winningLotto);
    }

    public void runLottoGame(LottoGameDto dto) {
        lottoGameService.game(dto);
    }
}
