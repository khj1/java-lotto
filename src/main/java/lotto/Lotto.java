package lotto;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isValidSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE);
        }
    }

    private static boolean isValidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    // TODO: 추가 기능 구현
}
