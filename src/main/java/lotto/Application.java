package lotto;

import lotto.Controller.PlayController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayController playController = new PlayController();
        playController.play();
        playController.setResult();
        playController.showResult();
    }
}
