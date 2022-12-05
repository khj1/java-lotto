package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoResult {

    private final List<Rank> results;

    private LottoResult(List<Rank> results) {
        this.results = results;
    }

    public static LottoResult of(List<Rank> results) {
        return new LottoResult(results);
    }

    public int count(Rank rank) {
        return Collections.frequency(results, rank);
    }

    public double calculateProfit(Money money) {
        double totalAmount = getTotalAmount();

        return money.calculateProfitRate(totalAmount);
    }

    private double getTotalAmount() {
        return results.stream()
                .mapToDouble(Rank::getAmount)
                .sum();
    }
}
