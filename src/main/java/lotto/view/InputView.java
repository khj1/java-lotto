package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Money;

public class InputView {

    public Money readMoney() {
        return Money.from(Console.readLine());
    }
}
