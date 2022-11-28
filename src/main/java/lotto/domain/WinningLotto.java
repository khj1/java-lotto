package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, LottoNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Rank compare(Lotto purchasedLotto) {
        int matchCount = winningLotto.countMatch(purchasedLotto);
        boolean hasBonusNumber = purchasedLotto.contains(bonusNumber);

        return Rank.of(matchCount, hasBonusNumber);
    }
}
