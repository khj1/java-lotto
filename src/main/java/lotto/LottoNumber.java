package lotto;

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

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }
}
