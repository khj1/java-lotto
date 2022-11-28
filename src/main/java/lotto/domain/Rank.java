package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LAST(0, 0);

    private final int matchCount;
    private double amount;

    Rank(int matchCount, double amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Rank of(int matchCount, boolean hasBonusNumber) {
        if (needBonusNumber(matchCount) && !hasBonusNumber) {
            return THIRD;
        }
        return getRankByMatchCount(matchCount);
    }

    private static boolean needBonusNumber(int matchCount) {
        return matchCount == SECOND.matchCount;
    }

    private static Rank getRankByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.hasSameMatchCount(matchCount))
                .findFirst()
                .orElse(LAST);
    }

    private boolean hasSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public double getAmount() {
        return amount;
    }
}
