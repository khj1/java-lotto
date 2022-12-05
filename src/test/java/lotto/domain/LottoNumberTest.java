package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("로또 번호에 관한 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void createInvalidLottoNumber(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.from(number));
    }
}
