package lotto;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    public static final int VERY_FRONT = 0;

    @DisplayName("구입 금액에 맞게 로또를 여러 장 생성하는 기능 테스트")
    @Test
    void createLottoByMoney() {
        LottoNumbersGenerator testNumbersGenerator = new LottoTestNumbersGenerator();
        LottoMachine machine = new LottoMachine(testNumbersGenerator);
        Money money = Money.from("8000");

        Lottos lottos = machine.purchase(money);

        assertThat(lottos.size()).isEqualTo(8);
    }

    static class LottoTestNumbersGenerator implements LottoNumbersGenerator{

        private final List<List<Integer>> numbers;

        private LottoTestNumbersGenerator() {
            numbers = Lists.newArrayList(
                    List.of(8, 21, 23, 41, 42, 43),
                    List.of(3, 5, 11, 16, 32, 38),
                    List.of(7, 11, 16, 35, 36, 44),
                    List.of(1, 8, 11, 31, 41, 42),
                    List.of(13, 14, 16, 38, 42, 45),
                    List.of(7, 11, 30, 40, 42, 43),
                    List.of(2, 13, 22, 32, 38, 45),
                    List.of(1, 3, 5, 14, 22, 45)
            );
        }

        @Override
        public List<Integer> generate() {
            return numbers.remove(VERY_FRONT);
        }
    }
}
