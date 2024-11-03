package lotto.io;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Ticket;

public abstract class Output {
    public static void lottos(Ticket ticket) {
        List<Lotto> lottos = ticket.getLottos();
        System.out.println(lottos.size() + "개를 구입했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void result(Ticket ticket) {
        System.out.println("당첨 통계");
        EnumMap<Prize, Integer> result = ticket.getResult();
        result.forEach((prize, integer) ->
                System.out.println(prize.getMatchCount() + "개 일치 (" + prize.getPrizeMoney() + "원) - " + integer + "개")
        );
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("총 수익률은 " + formatter.format(ticket.getEarningRate()) + "%입니다.");
    }
}
