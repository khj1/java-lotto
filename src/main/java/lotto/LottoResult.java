package lotto;

import java.util.Collections;
import java.util.List;

public class LottoResult {

    private List<Rank> results;

    private LottoResult(List<Rank> results) {
        this.results = results;
    }

    public static LottoResult of(List<Rank> results) {
        return new LottoResult(results);
    }

    public int count(Rank rank) {
        return Collections.frequency(results, rank);
    }
}
