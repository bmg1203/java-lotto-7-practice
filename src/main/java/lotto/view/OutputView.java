package lotto.view;

import java.util.List;
import lotto.model.dto.LottoDto;
import lotto.model.dto.ResultDto;
import lotto.view.formatter.OutputFormatter;

public class OutputView {

    private OutputView() {
    }

    public static void displayLottoNumbersOfCustomer(List<LottoDto> lottoDtos) {
        String sizeOfLotto = OutputFormatter.formatSizeOfLotto(lottoDtos);
        List<String> lottoNumbers = OutputFormatter.formatLottoNumbers(lottoDtos);

        System.out.println(sizeOfLotto);
        lottoNumbers.forEach(System.out::println);
    }

    public static void displayResult(ResultDto resultDto) {
        List<String> rankCounts = OutputFormatter.formatRankCount(resultDto.rankDtos());
        rankCounts.forEach(System.out::println);

        System.out.println(OutputFormatter.formatProfitRate(resultDto.profitRate()));
    }
}
