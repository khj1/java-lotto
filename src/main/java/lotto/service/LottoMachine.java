package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.LottoNumbersGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    private final LottoNumbersGenerator numbersGenerator;

    public LottoMachine(LottoNumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos purchase(Money money) {
        int quantity = money.countAvailable();

        return Lottos.from(getLottos(quantity));
    }

    private List<Lotto> getLottos(int quantity) {
        return Stream.generate(() -> Lotto.from(numbersGenerator.generate()))
                .limit(quantity)
                .collect(Collectors.toList());
    }
}
