package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    LAST(0);

    private final int matchCount;

    Rank(int matchCount) {
        this.matchCount = matchCount;
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
}
