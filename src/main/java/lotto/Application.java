package lotto;


import controller.Controller;
import lottoManager.LottoWinningResult;
import repository.PurchasedLottoRepository;
import repository.WinningNumberRepository;
import service.LottoService;
import service.LottoServiceImpl;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import view.OutputViewImpl;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

//        Lotto 클래스
//        제공된 Lotto 클래스를 사용하여 구현해야 한다.
//        Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
//        numbers의 접근 제어자인 private은 변경할 수 없다.
//        Lotto의 패키지를 변경할 수 있다.

//        간단한 로또 발매기를 구현한다.
//
//        로또 번호의 숫자 범위는 1~45까지이다.
//        1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
//                당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
//        당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
//        1등: 6개 번호 일치 / 2,000,000,000원
//        2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
//        3등: 5개 번호 일치 / 1,500,000원
//        4등: 4개 번호 일치 / 50,000원
//        5등: 3개 번호 일치 / 5,000원
//        로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
//                로또 1장의 가격은 1,000원이다.
//                당첨 번호와 보너스 번호를 입력받는다.
//        사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
//                사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
//                Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
//                입출력 요구 사항
//        입력
//        로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

        InputView inputView = new InputViewImpl();
        OutputView outputView = new OutputViewImpl();
        PurchasedLottoRepository purchasedLottoRepository = new PurchasedLottoRepository();
        WinningNumberRepository winningNumberRepository = new WinningNumberRepository();
        LottoWinningResult lottoWinningResult = new LottoWinningResult();
        LottoService lottoService = new LottoServiceImpl(purchasedLottoRepository,winningNumberRepository,lottoWinningResult);

        Controller controller = new Controller(inputView,outputView, lottoService);
        controller.play();

    }
}
