package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.domain.Customer;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoManager;
import lotto.model.dto.LottosResponse;
import lotto.model.repository.LottoRepository;
import lotto.model.service.parser.NumberParser;

public class LottoService {

    private final LottoRepository lottoRepository;
    private final LottoManager lottoManager;

    public LottoService() {
        this.lottoRepository = new LottoRepository();
        this.lottoManager = new LottoManager();
    }

    public Integer savePayment(String payment) {
        Customer customer = new Customer(payment);
        lottoRepository.saveCustomer(customer);
        return customer.getId();
    }

    public LottosResponse issueLottos(Integer customerId) {
        Customer customer = lottoRepository.findById(customerId);
        int count = customer.getPayment() / 1000;

        List<Lotto> generatedLottos = IntStream.range(0, count)
                .mapToObj(iter -> {
                    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    numbers.sort(Integer::compareTo);
                    return new Lotto(numbers);
                })
                .toList();

        lottoRepository.updateCustomerLottos(customerId, generatedLottos);
        return new LottosResponse(generatedLottos);
    }

    public String saveWinningLottos(String winningNumbers) {
        List<Integer> numbers = NumberParser.parseWinningNumbers(winningNumbers);
        lottoManager.saveWinningLotto(new Lotto(numbers));
        return "success";
    }
}
