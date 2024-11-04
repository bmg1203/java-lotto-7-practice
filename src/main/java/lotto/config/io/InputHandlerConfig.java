package lotto.config.io;

import lotto.config.io.reader.ReaderConfig;
import lotto.config.io.writer.WriterConfig;
import lotto.io.inputHandler.DefaultInputHandler;
import lotto.io.inputHandler.InputHandler;

public class InputHandlerConfig {

    private final InputHandler inputHandler;

    public InputHandlerConfig(ReaderConfig readerConfig, WriterConfig writerConfig) {
        this.inputHandler = new DefaultInputHandler(readerConfig.getReader(), writerConfig.getWriter());
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }
}
