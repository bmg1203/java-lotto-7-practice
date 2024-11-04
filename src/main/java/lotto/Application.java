package lotto;

import java.util.List;
import lotto.domain.controller.LottoController;
import lotto.domain.service.LottoService;
import lotto.domain.util.parser.DelimitedNumberParser;
import lotto.domain.util.parser.MoneyParser;
import lotto.domain.util.parser.StringParser;
import lotto.global.io.InputConsole;
import lotto.global.io.OutputConsole;

public class Application {
    public static void main(String[] args) {
        StringParser<List<Integer>> numberParser = DelimitedNumberParser.getInstance();
        StringParser<Integer> moneyParser = MoneyParser.getInstance();
        OutputConsole.init(System.out);
        OutputConsole output = OutputConsole.getInstance();

        LottoService.init(numberParser, moneyParser);
        LottoService service = LottoService.getInstance();

        try (InputConsole input = new InputConsole()) {
            LottoController.init(service, input, output);
            LottoController controller = LottoController.getInstance();

            controller.play();
        }
    }
}
