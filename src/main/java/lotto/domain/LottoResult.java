package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult() {
        this.result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void compareLottos(List<Lotto> userLottos, WinningLotto winningLotto) {
        for (Lotto lotto : userLottos) {
            Rank rank = winningLotto.match(lotto);
            result.put(rank, result.get(rank) + 1);
        }
    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            totalPrize += (long) entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return totalPrize;
    }

    public double calculateYield(int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        long totalPrize = calculateTotalPrize();
        double yield = ((double) totalPrize / purchaseAmount) * 100;

        return Math.round(yield * 10.0) / 10.0;
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
