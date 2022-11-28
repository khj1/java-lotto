package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public LottoResult compare(WinningLotto winningLotto) {
        return LottoResult.of(compareEach(winningLotto));
    }

    private List<Rank> compareEach(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::compare)
                .collect(Collectors.toList());
    }

    public int size() {
        return lottos.size();
    }
}
