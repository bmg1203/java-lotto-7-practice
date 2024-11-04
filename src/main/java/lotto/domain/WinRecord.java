package lotto.domain;

import lotto.ExceptionMessages;

import java.util.*;

public class WinRecord {
    public static final List<Integer> WINNING_PRIZES = Collections.unmodifiableList(Arrays.asList(0, 2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000));
    private static WinRecord winRecordInstance;
    private final List<Integer> winRecord = new ArrayList<>(Collections.nCopies(ValidatorWinRecord.MAX_WIN_RANK + 1, 0));

    private WinRecord(List<Integer> winRecordInput) {
        new ValidatorWinRecord(winRecordInput);
        setWinRecord(winRecordInput);
    }

    public static WinRecord getWinRecord() {
        if (winRecordInstance == null) throw new IllegalArgumentException
                (ExceptionMessages.SINGLETON_NOT_CREATED_EXCEPTION_MESSAGE.getMessage());
        return winRecordInstance;
    }

    public static WinRecord getWinRecord(List<Integer> winRecordInput) {
        if (winRecordInstance == null) winRecordInstance = new WinRecord(winRecordInput);
        return winRecordInstance;
    }

    private void setWinRecord(List<Integer> winRecordInput) {
        for (Integer winRank : winRecordInput) {
            if (winRank != ValidatorWinRecord.NO_WIN_NUM) {
                winRecord.set(winRank, winRecord.get(winRank) + 1);
            }
        }
    }

    public List<Integer> getWinRecordCounts() {
        return winRecord;
    }

    public long getTotalWinningPrize() {
        long totalWinningPrize = 0;
        for (int i = 1; i < winRecord.size(); i++) {
            totalWinningPrize += winRecord.get(i) * WINNING_PRIZES.get(i);
        }
        return totalWinningPrize;
    }

    public static void resetInstance() {
        if ("true".equals(System.getProperty("IS_TEST_ENV"))) {
            winRecordInstance = null;
        }
    }


    private static class ValidatorWinRecord {
        private static final int MIN_WIN_RANK = 1;
        private static final int MAX_WIN_RANK = 5;
        private static final int NO_WIN_NUM = 0;

        public ValidatorWinRecord(List<Integer> winRecordInput) {
            checkBoundaryWinRecode(winRecordInput);
        }

        private static void checkBoundaryWinRecode(List<Integer> winRecordInput) {
            for (Integer winRank : winRecordInput) {
                if (winRank != NO_WIN_NUM && winRank > MAX_WIN_RANK)
                    throw new IllegalArgumentException
                            (ExceptionMessages.WINNING_RANK_EXCEPTION_MESSAGE.getMessage());
                if (winRank != NO_WIN_NUM && winRank < MIN_WIN_RANK)
                    throw new IllegalArgumentException
                            (ExceptionMessages.WINNING_RANK_EXCEPTION_MESSAGE.getMessage());
            }
        }
    }
}
