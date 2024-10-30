package lotto.view.input.hanlder.infrastructure;

import lotto.view.input.domain.InputService;
import lotto.view.input.hanlder.domain.InputHandlerService;
import lotto.view.output.infrastructure.ErrorOutput;

import java.util.function.Function;

public class WinningLottoHandler implements InputHandlerService {
    private final InputService inputService;
    public WinningLottoHandler(InputService inputService) {
        this.inputService = inputService;
    }
    @Override
    public <R> R retrieveReceive(Function<String, R> function) {
        try {
            String input = inputService.input();
            return function.apply(input);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            ErrorOutput.view(illegalArgumentException);
            return retrieveReceive(function);
        }
    }
}
