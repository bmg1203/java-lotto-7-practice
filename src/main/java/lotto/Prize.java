package lotto;

public enum Prize {
    fifth(5_000), forth(50_000), third(1_500_500), second(30_000_000), first(2_000_000_000);

    Integer prize;

    Prize(Integer p) {
        prize = p;
    }
}
