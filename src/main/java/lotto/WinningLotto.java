package lotto;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(List<Integer> numbers, LottoNumber bonusNumber) {
        this.winningLotto = Lotto.from(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, LottoNumber bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public Rank compare(Lotto purchasedLotto) {
        int matchCount = winningLotto.countMatch(purchasedLotto);
        boolean hasBonusNumber = purchasedLotto.contains(bonusNumber);

        return Rank.of(matchCount, hasBonusNumber);
    }
}
