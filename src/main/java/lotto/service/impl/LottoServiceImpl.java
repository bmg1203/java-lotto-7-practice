package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_SAVE_MONEY;

import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.repository.SingleRepository;
import lotto.service.LottoService;

public class LottoServiceImpl implements LottoService {

    private final SingleRepository<Money> moneyRepository;
    private final SingleRepository<LottoList> lottoListRepository;

    public LottoServiceImpl(SingleRepository<Money> moneyRepository,
                            SingleRepository<LottoList> lottoListRepository) {
        this.moneyRepository = moneyRepository;
        this.lottoListRepository = lottoListRepository;
    }

    @Override
    public MoneyDto createMoney(String input) {
        Money money = Money.create(input);
        moneyRepository.save(money);

        return money.toDto();
    }

    @Override
    public LottoListDto generateLottoList() {
        Money money = moneyRepository.get()
                .orElseThrow(() -> new NullPointerException(NOT_SAVE_MONEY.getMessage()));

        LottoList lottoList = LottoList.generate(money);
        lottoListRepository.save(lottoList);

        return lottoList.toDto();
    }
}
