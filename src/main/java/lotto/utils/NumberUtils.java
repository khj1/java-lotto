package lotto.utils;

import lotto.constant.ErrorMessage;

public class NumberUtils {

    public static int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception error) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_NUMBER);
        }
    }
}
