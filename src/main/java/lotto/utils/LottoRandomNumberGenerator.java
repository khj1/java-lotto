package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class LottoRandomNumberGenerator implements LottoNumbersGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN, LottoNumber.MAX, Lotto.LOTTO_SIZE);
    }
}
