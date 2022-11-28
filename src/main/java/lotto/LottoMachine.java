package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int START_INCLUSIVE = 0;

    private LottoNumbersGenerator numbersGenerator;

    public LottoMachine(LottoNumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos purchase(Money money) {
        int quantity = money.countAvailable();

        return Lottos.from(getLottos(quantity));
    }

    private List<Lotto> getLottos(int quantity) {
        return IntStream.range(START_INCLUSIVE, quantity)
                .mapToObj(operand -> Lotto.from(numbersGenerator.generate()))
                .collect(Collectors.toList());
    }
}
