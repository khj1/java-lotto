package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.utils.LottoRandomNumberGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        Money money = inputView.readMoney();
        Lottos purchasedLottos = purchaseLotto(money);

        outputView.printPurchaseResult(purchasedLottos);

        WinningLotto winningLotto = requestWinningLotto();
        LottoResult result = purchasedLottos.compare(winningLotto);

        outputView.printWinningResult(result, money);
    }

    private WinningLotto requestWinningLotto() {
        Lotto lotto = inputView.readWinningLotto();
        LottoNumber bonusNumber = inputView.readBonusNumber();

        return WinningLotto.of(lotto, bonusNumber);
    }

    private static Lottos purchaseLotto(Money money) {
        LottoMachine lottoMachine = new LottoMachine(new LottoRandomNumberGenerator());

        return lottoMachine.purchase(money);
    }
}
