package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.GuidanceMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.utils.NumberUtils;

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

    public Lotto readWinningLotto() {
        printRequestWinningNumbers();

        return getWinningLotto();
    }

    private void printRequestWinningNumbers() {
        System.out.println(GuidanceMessage.REQUEST_WINNING_NUMBERS);
    }

    private static String[] separateNumbers() {
        return Console.readLine().split(REGEX);
    }

    private List<Integer> getWinningNumbers(String[] separatedNumbers) {
        return Arrays.stream(separatedNumbers)
                .map(NumberUtils::toInteger)
                .collect(Collectors.toList());
    }

    private Lotto getWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers(separateNumbers());

        return Lotto.from(winningNumbers);
    }

    public LottoNumber readBonusNumber() {
        printRequestBonusNumber();

        return LottoNumber.from(Console.readLine());
    }

    private void printRequestBonusNumber() {
        System.out.println(GuidanceMessage.REQUEST_BONUS_NUMBER);
    }
}
