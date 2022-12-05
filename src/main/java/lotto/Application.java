package lotto;

import lotto.controller.LottoController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController lottoController = new LottoController();
            lottoController.run();
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
        }
    }
}
