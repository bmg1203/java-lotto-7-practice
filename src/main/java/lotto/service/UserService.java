package lotto.service;

import lotto.domain.user.User;
import lotto.domain.user.UserRepository;
import lotto.util.ProgramExit;
import lotto.view.ErrorOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.enums.LottoConstant.ACCESS_COUNT;
import static lotto.view.OutputView.ENTER_PURCHASE_PRICE;

public class UserService {
    // 싱글톤 패턴
    private static final UserService instance = new UserService();
    private final UserRepository userRepository = UserRepository.getInstance();

    private UserService() {

    }

    public static UserService getInstance() {
        return instance;
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public int inputPurchasePriceForUser() {
        int accessCount = ACCESS_COUNT.getValue();
        for(int count = 0; count < accessCount; count++) {
            String purchasePrice = inputPurchasePrice();
            try {
                User user = new User(purchasePrice);
                return userRepository.save(user).getId();
            } catch (IllegalArgumentException e) {
                ErrorOutputView.printErrorMessage(e.getMessage());
            }
        }
        ProgramExit.run(accessCount);
        return -1;
    }

    private String inputPurchasePrice() {
        OutputView.printMessage(ENTER_PURCHASE_PRICE);
        return InputView.readLine();
    }

}
