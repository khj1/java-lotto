package lotto.domain;

import lotto.constant.ErrorMessage;

public class Money {
    public static final int DIVIDED = 0;
    public static final int PERCENTAGE_CONVERTER = 100;

    private final int money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        if (isNonNumeric(money)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_MONEY);
        }
        if (isNotDividedByLottoPrice(Integer.parseInt(money))) {
            throw new IllegalArgumentException(ErrorMessage.UNDIVIDED_BY_LOTTO_PRICE);
        }
    }

    private boolean isNotDividedByLottoPrice(int money) {
        return money % Lotto.PRICE != DIVIDED;
    }

    private boolean isNonNumeric(String money) {
        return !money.chars().allMatch(Character::isDigit);
    }

    public static Money from(String money) {
        return new Money(money);
    }

    public int countAvailable() {
        return money / Lotto.PRICE;
    }

    public double calculateProfitRate(double totalAmount) {
        return totalAmount / money * PERCENTAGE_CONVERTER;
    }
}
