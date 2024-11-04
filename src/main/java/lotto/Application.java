package lotto;

import controller.LottoController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
