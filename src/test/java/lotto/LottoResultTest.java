package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("각 등수별 당첨 횟수를 세는 기능 테스트")
    @Test
    void createCountWinningTest() {
        LottoMachine lottoMachine = new LottoMachine(new LottoTestNumbersGenerator());
        Lottos lottos = lottoMachine.purchase(Money.from("8000"));
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResult result = lottos.compare(winningLotto);

        assertThat(result.count(Rank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("수익률 계산 기능 테스트")
    @Test
    void createProfitRateTest() {
        LottoMachine lottoMachine = new LottoMachine(new LottoTestNumbersGenerator());
        Money money = Money.from("8000");
        Lottos lottos = lottoMachine.purchase(money);
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResult result = lottos.compare(winningLotto);
        double profit = result.calculateProfit(money);

        assertThat(String.format("%.1f%%", profit)).isEqualTo("62.5%");
    }
}
