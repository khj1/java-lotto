package lotto.view;

import lotto.Lottos;

public class OutputView {

    public static final String PURCHASED_COUNT_MESSAGE = "%d개를 구매했습니다.%n";

    public void printPurchaseResult(Lottos lottos) {
        printQuantity(lottos);
        printLottoNumbers(lottos);
    }

    private void printQuantity(Lottos lottos) {
        System.out.printf(PURCHASED_COUNT_MESSAGE, lottos.size());
    }

    private void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos);
        System.out.println();
    }
}
