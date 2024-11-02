package lotto.service.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.strategy.FifthPlace;
import lotto.strategy.FirstPlace;
import lotto.strategy.FourthPlace;
import lotto.strategy.PlaceAuction;
import lotto.strategy.SecondPlace;
import lotto.view.PrintMessage;

public class ResultCalculator {

    private final Map<Integer, Integer> placeMap = new HashMap<>();
    private final Map<Integer, PlaceAuction> placeAuctionMap = new HashMap<>();
    private final List<Integer> prize = Prize.getPrize();

    private ResultCalculator(List<Integer> winningResult, List<Integer> bonusResult) {
        init(bonusResult);
        calculate(winningResult, bonusResult);
    }

    public static ResultCalculator create(List<Integer> winningResult, List<Integer> bonusResult) {
        return new ResultCalculator(winningResult, bonusResult);
    }

    private void init(List<Integer> bonusResult) {
        for (int place = 1; place <= 5; place++) {
            placeMap.put(place, 0);
        }
        placeAuctionMap.put(6, new FirstPlace(placeMap));
        placeAuctionMap.put(5, new SecondPlace(placeMap, bonusResult));
        placeAuctionMap.put(4, new FourthPlace(placeMap));
        placeAuctionMap.put(3, new FifthPlace(placeMap));
    }

    private void calculate(List<Integer> winningResult, List<Integer> bonusResult) {
        int totalCount = winningResult.size();
        for (int count = 0; count < totalCount; count++) {
            int winning = winningResult.get(count);
            update(winning, count);
        }
    }

    private void update(Integer winning, Integer count) {
        if (placeAuctionMap.containsKey(winning)) {
            PlaceAuction placeAuction = placeAuctionMap.get(winning);
            placeAuction.add(count);
        }
    }

    private String setDetail(PrintMessage printMessage, Integer place) {
        return String.format(printMessage.getMessage(), placeMap.get(place));
    }

    public List<String> getDetail() {
        List<String> printResult = new ArrayList<>();
        printResult.add(setDetail(PrintMessage.LOTTO_FIFTH_PLACE_WINNING, 5));
        printResult.add(setDetail(PrintMessage.LOTTO_FOURTH_PLACE_WINNING, 4));
        printResult.add(setDetail(PrintMessage.LOTTO_THIRD_PLACE_WINNING, 3));
        printResult.add(setDetail(PrintMessage.LOTTO_SECOND_PLACE_WINNING, 2));
        printResult.add(setDetail(PrintMessage.LOTTO_FIRST_PLACE_WINNING, 1));
        return printResult;
    }

    public Integer getPrizeMoney() {
        int prizeMoney = 0;
        for (int place = 1; place <= 5; place++) {
            prizeMoney += placeMap.get(place) * prize.get(place - 1);
        }
        return prizeMoney;
    }
}
