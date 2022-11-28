package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String REGEX = ",";

    public Money readMoney() {
        return Money.from(Console.readLine());
    }

    public Lotto readLottoNumbers() {
        String[] separatedByRegex = Console.readLine().split(REGEX);

        return Lotto.from(getNumbers(separatedByRegex));
    }

    private static List<Integer> getNumbers(String[] separatedNumbers) {
        return Arrays.stream(separatedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
