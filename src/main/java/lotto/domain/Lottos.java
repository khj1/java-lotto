package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    public static final String NEW_LINE = "\n";

    private final List<Lotto> lottos;

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

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        lottos.forEach(lotto -> message.append(lotto).append(NEW_LINE));

        return message.toString();
    }
}
