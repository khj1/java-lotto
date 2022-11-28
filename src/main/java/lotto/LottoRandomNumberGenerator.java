package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoRandomNumberGenerator implements LottoNumbersGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN, LottoNumber.MAX, Lotto.LOTTO_SIZE);
    }
}
