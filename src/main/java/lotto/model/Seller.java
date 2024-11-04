package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.Utils;
import lotto.view.Error;

public class Seller {
    private static final String PAY_PATTERN = "^[1-9][0-9]{3,}";

    public void validate(String input) {
        Pattern patternPay = Pattern.compile(PAY_PATTERN);
        Matcher matcherPay = patternPay.matcher(input);

        if (!matcherPay.matches()) {
            Error.reject(Error.INVALID_MSG);
        }
        
        if (Utils.strToInteger(input) % 1000 != 0) {
            Error.reject(Error.MONEY_MSG);
        }
    }

    public List<Lotto> createLottoTickets(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int howmany = money / 1000;

        for (int i = 0; i < howmany; i++) {
            setLottoTicket(lottos, new Lotto(Utils.getLottoNumber()));
        }

        return lottos;
    }

    public void setLottoTicket(List<Lotto> lottos, Lotto lotto) {
        lottos.add(lotto);
    }
}
