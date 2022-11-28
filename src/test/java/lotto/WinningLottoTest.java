package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("로또 번호를 비교하는 기능 테스트")
    @ParameterizedTest(name = "로또 번호 : {0}, 당첨 결과 : {1}")
    @MethodSource("createPurchasedLottoAndRank")
    void compareLottoNumber(List<Integer> numbers, Rank rank) {
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7));
        Lotto lotto = Lotto.from(numbers);

        assertThat(winningLotto.compare(lotto)).isEqualTo(rank);
    }

    public static Stream<Arguments> createPurchasedLottoAndRank() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.arguments(List.of(1, 2, 3, 4, 8, 9), Rank.FOURTH),
                Arguments.arguments(List.of(1, 2, 3, 8, 9, 10), Rank.FIFTH)
        );
    }
}
