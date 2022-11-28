package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.GuidanceMessage;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String REGEX = ",";

    public Money readMoney() {
        printRequestMoneyMessage();

        return Money.from(Console.readLine());
    }

    private void printRequestMoneyMessage() {
        System.out.println(GuidanceMessage.REQUEST_MONEY);
    }

    public Lotto readLottoNumbers() {
        printRequestWinningNumbers();

        String[] separatedByRegex = Console.readLine().split(REGEX);

        return Lotto.from(getNumbers(separatedByRegex));
    }

    private void printRequestWinningNumbers() {
        System.out.println(GuidanceMessage.REQUEST_WINNING_NUMBERS);
    }

    private static List<Integer> getNumbers(String[] separatedNumbers) {
        return Arrays.stream(separatedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public LottoNumber readBonusNumber() {
        printRequestBonusNumber();

        return LottoNumber.from(Console.readLine());
    }

    private void printRequestBonusNumber() {
        System.out.println(GuidanceMessage.REQUEST_BONUS_NUMBER);
    }
}
