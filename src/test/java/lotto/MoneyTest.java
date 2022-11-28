package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {

    @DisplayName("구입 금액에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "-1000", "1001", "1000r"})
    void createInvalidMoney(String money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.from(money));
    }
}
