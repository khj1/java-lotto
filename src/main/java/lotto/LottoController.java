package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        Money money = inputView.readMoney();

        LottoMachine lottoMachine = new LottoMachine(new LottoRandomNumberGenerator());
        Lottos purchasedLottos = lottoMachine.purchase(money);

        outputView.printPurchaseResult(purchasedLottos);

        List<Integer> lotto = inputView.readLottoNumbers();
        LottoNumber bonusNumber = inputView.readBonusNumber();

        WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);
        LottoResult result = purchasedLottos.compare(winningLotto);

        outputView.printWinningResult(result, money);
    }
}
