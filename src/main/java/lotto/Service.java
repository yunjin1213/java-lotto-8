package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    Calculator calculator = new Calculator();
    RandomNumberCreator randomNumberCreator = new RandomNumberCreator();

    public Receipt createReceipt(int amountOfMoney) {

        int amountOfLotteries = calculator.calculateAmountOfLotteriesWithMoney(amountOfMoney);

        Receipt receipt = new Receipt(amountOfMoney, amountOfLotteries);

        return  receipt;
    }

    public List<Lotto> createLotteries(int amountOfLotteries) {
        // 개수 -> 로또 발급!

        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < amountOfLotteries; i++) {
            List<Integer> numbers = randomNumberCreator.createRandomLottoNumbers();
            Lotto lotto = new Lotto(numbers);

            lotteries.add(lotto);
        }
        // perhaps,, lotteries의 개수 검증..??
        return lotteries;
    }

    public WinningLotto createWinningLotto(List<Integer> numbers, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);

        return winningLotto;
    }

    public Map<Rank, Integer> createRankCounts(WinningLotto winningLotto, List<Lotto> lotteries) {
        Map<Rank, Integer> rankCounts = new HashMap<>();

        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }

        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lotteries) {
            int matchCount = lotto.matchWinningNumbers(winningNumbers);
            boolean bonusMatch = lotto.matchBonusNumber(bonusNumber);

            Rank rank = determineRank(matchCount, bonusMatch);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        return rankCounts;
    }


    public Result createResult(Map<Rank, Integer> rankCount, int amountOfMoney){

        Calculator calculator = new Calculator();
        Long prize = calculator.calculatePrize(rankCount);

        double profitRate = calculator.calculateProfitRate(amountOfMoney,prize);

        Result result = new Result(prize, profitRate);

        return result;
    }

    private Rank determineRank(int matchCount, boolean bonusMatch) {
        // 맘에 들지 않지만.. 얘를 누가 책임져야 할 지 더 고민해보자.
        if (matchCount == 6) {
            return Rank.First;
        }
        if (matchCount == 5 && bonusMatch) {
            return Rank.Second;
        }
        if (matchCount == 5) {
            return Rank.Third;
        }
        if (matchCount == 4) {
            return Rank.Fourth;
        }
        if (matchCount == 3) {
            return Rank.Fifth;
        }
        return Rank.MISS;
    }

}
