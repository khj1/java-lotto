package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("구입 금액에 맞게 로또를 여러 장 생성하는 기능 테스트")
    @Test
    void createLottoByMoney() {
        LottoNumbersGenerator testNumbersGenerator = new LottoTestNumbersGenerator();
        LottoMachine machine = new LottoMachine(testNumbersGenerator);
        Money money = Money.from("8000");

        Lottos lottos = machine.purchase(money);

        assertThat(lottos.size()).isEqualTo(8);
    }
}
