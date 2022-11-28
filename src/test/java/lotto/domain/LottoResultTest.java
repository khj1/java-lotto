package lotto.domain;

import lotto.LottoTestNumbersGenerator;
import lotto.service.LottoMachine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    static Money money;
    static Lottos lottos;
    static WinningLotto winningLotto;

    @BeforeAll
    static void setUp() {
        money = Money.from("8000");
        lottos = purchaseLottos(money);
        winningLotto = getWinningLotto();
    }

    @DisplayName("각 등수별 당첨 횟수를 세는 기능 테스트")
    @Test
    void createCountWinningTest() {
        LottoResult result = lottos.compare(winningLotto);

        assertThat(result.count(Rank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("수익률 계산 기능 테스트")
    @Test
    void createProfitRateTest() {
        LottoResult result = lottos.compare(winningLotto);
        double profit = result.calculateProfit(money);

        assertThat(String.format("%.1f%%", profit)).isEqualTo("62.5%");
    }

    private static Lottos purchaseLottos(Money money) {
        LottoMachine lottoMachine = new LottoMachine(new LottoTestNumbersGenerator());

        return lottoMachine.purchase(money);
    }

    private static WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        return WinningLotto.of(Lotto.from(winningNumbers), LottoNumber.from(7));
    }
}
