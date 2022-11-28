package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isValidSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE);
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.size() != LOTTO_SIZE;
    }

    private static boolean isValidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    public int countMatch(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    // TODO: 추가 기능 구현
}
