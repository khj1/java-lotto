package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    public static final int DIVISIBLE = 0;
    public static final int DEFAULT_COUNT = 0;

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int money) {
        validate(money);
        purchaseRandomLottos(money);
    }

    private void purchaseRandomLottos(int money) {
        int balance = money;
        while (balance >= LOTTO_PRICE) {
            lottos.add(Lotto.creatRandom());
            balance -= LOTTO_PRICE;
        }
    }

    Lottos(Lotto... lottos) {
        for (Lotto lotto : lottos) {
            this.lottos.add(lotto);
        }
    }

    private void validate(int money) {
        if (isMoneyIndivisibleByPrice(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_LEFT_OVER);
        }
    }

    private static boolean isMoneyIndivisibleByPrice(int money) {
        return money % LOTTO_PRICE != DIVISIBLE;
    }

    public int countTotal() {
        return lottos.size();
    }

    public double calculateProfit(Lotto winningLotto, int bonusNumber) {
        int winningAmount = getWinningAmount(winningLotto, bonusNumber);
        int money = getMoney();

        return (double) winningAmount / money * 100;
    }

    public Map<LottoResult, Integer> getWinningCounts(Lotto winningLotto, int bonusNumber) {
        HashMap<LottoResult, Integer> winningCounts = getEmptyWinningCounts();
        for (Lotto lotto : lottos) {
            LottoResult lottoResult = lotto.getResult(winningLotto, bonusNumber);
            Integer winningCount = winningCounts.getOrDefault(lottoResult, 0) + 1;
            winningCounts.put(lottoResult, winningCount);
        }
        return winningCounts;
    }

    private HashMap<LottoResult, Integer> getEmptyWinningCounts() {
        HashMap<LottoResult, Integer> emptyWinningCounts = new HashMap<>();
        for (LottoResult lottoResult : LottoResult.values()) {
            emptyWinningCounts.put(lottoResult, DEFAULT_COUNT);
        }
        return emptyWinningCounts;
    }

    private int getMoney() {
        return LOTTO_PRICE * lottos.size();
    }

    private int getWinningAmount(Lotto winningLotto, int bonusNumber) {
        int winningAmount = 0;
        for (Lotto lotto : lottos) {
            LottoResult lottoResult = lotto.getResult(winningLotto, bonusNumber);
            winningAmount += lottoResult.getAmount();
        }
        return winningAmount;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        for (Lotto lotto : lottos) {
            message.append(lotto).append("\n");
        }
        return message.toString();
    }
}
