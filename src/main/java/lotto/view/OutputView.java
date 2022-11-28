package lotto.view;

import lotto.LottoResult;
import lotto.Lottos;
import lotto.Money;
import lotto.Rank;

public class OutputView {

    public static final String PURCHASED_COUNT_MESSAGE = "%d개를 구매했습니다.%n";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final String SEPARATOR = "---";
    public static final String RESULT_INTRO = "당첨 통계";
    public static final String FIFTH_RANK_COUNT = "3개 일치 (5,000원) - %d개%n";
    public static final String FOURTH_RANK_COUNT = "4개 일치 (50,000원) - %d개%n";
    public static final String THIRD_RANK_COUNT = "5개 일치 (1,500,000원) - %d개%n";
    public static final String SECOND_RANK_COUNT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n";
    public static final String FIRST_RANK_COUNT = "6개 일치 (2,000,000,000원) - %d개%n";

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

    public void printWinningResult(LottoResult result, Money money) {
        printResultIntro();
        printWinningCounts(result);
        printProfitRate(result, money);
    }

    private void printResultIntro() {
        System.out.println(RESULT_INTRO);
        System.out.println(SEPARATOR);
    }

    private void printWinningCounts(LottoResult result) {
        System.out.printf(FIFTH_RANK_COUNT, result.count(Rank.FIFTH));
        System.out.printf(FOURTH_RANK_COUNT, result.count(Rank.FOURTH));
        System.out.printf(THIRD_RANK_COUNT, result.count(Rank.THIRD));
        System.out.printf(SECOND_RANK_COUNT, result.count(Rank.SECOND));
        System.out.printf(FIRST_RANK_COUNT, result.count(Rank.FIRST));
    }

    private void printProfitRate(LottoResult result, Money money) {
        System.out.printf(PROFIT_RATE_MESSAGE, result.calculateProfit(money));
    }
}
