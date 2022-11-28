package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int PRICE = 1_000;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = sort(numbers);

        this.numbers = convertToLottoNumbers(sortedNumbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> modifiableNumbers = new ArrayList<>(numbers);
        Collections.sort(modifiableNumbers);

        return modifiableNumbers;
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

    private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public int countMatch(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
