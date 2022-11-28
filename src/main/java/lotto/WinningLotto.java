package lotto;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = Lotto.from(numbers);
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public Rank compare(Lotto purchasedLotto) {
        int matchCount = winningLotto.countMatch(purchasedLotto);
        boolean hasBonusNumber = purchasedLotto.contains(bonusNumber);

        return Rank.of(matchCount, hasBonusNumber);
    }
}
