package lotto;

import lotto.utils.LottoNumbersGenerator;
import org.assertj.core.util.Lists;

import java.util.List;

public class LottoTestNumbersGenerator implements LottoNumbersGenerator {

    public static final int VERY_FRONT = 0;

    private final List<List<Integer>> numbers;

    public LottoTestNumbersGenerator() {
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
