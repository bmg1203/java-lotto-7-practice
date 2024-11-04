package lotto;

import lotto.config.AppConfig;
import lotto.controller.MainController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();

        MainController mainController = appConfig.serverController();
        mainController.run();
    }
}
