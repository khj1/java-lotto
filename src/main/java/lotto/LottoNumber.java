package lotto;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isInvalidRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    private boolean isInvalidRange(int number) {
        return number < MIN || number > MAX;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber from(String number) {
        return new LottoNumber(toInteger(number));
    }

    private static int toInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception error) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
