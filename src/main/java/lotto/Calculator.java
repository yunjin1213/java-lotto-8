package lotto;

import java.util.Map;

public class Calculator {

    public int calculateAmountOfLotteriesWithMoney(int money) {
        return money / 1000;
        // magic number 처리
    }

    public Long calculatePrize(Map<Rank, Integer> rankCount) {
        Long prize = 0L;

        for (Rank rank : Rank.values()) {
            prize += rankCount.get(rank).intValue() * rank.getPrize();
        }

        return prize;
    }

    public double calculateProfitRate(int amountOfMoney, Long prize) {
        return (double) amountOfMoney / prize;
    }
}
