package lotto;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        appConfig.controller().run();
    }
}
