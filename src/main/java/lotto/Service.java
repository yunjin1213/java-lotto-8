package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    //TODO: AppConfig 도입하기

    Calculator calculator = new Calculator();
    RandomNumberCreator randomNumberCreator = new RandomNumberCreator();

    public Receipt createReceipt(int amountOfMoney) {

        int amountOfLotteries = calculator.calculateAmountOfLotteriesWithMoney(amountOfMoney);

        Receipt receipt = new Receipt(amountOfMoney, amountOfLotteries);

        return  receipt;
    }

    public List<Lotto> createLotteries(int amountOfLotteries) {

        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < amountOfLotteries; i++) {
            List<Integer> numbers = randomNumberCreator.createRandomLottoNumbers();
            Lotto lotto = new Lotto(numbers);

            lotteries.add(lotto);
        }
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

    // TODO: refactoring 해야 함. service가 rank를 결정해주는게 적절하지 않음.
    private Rank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == Rank.First.getMatchCount()) {
            return Rank.First;
        }
        if (matchCount == Rank.Second.getMatchCount() && bonusMatch) {
            return Rank.Second;
        }
        if (matchCount == Rank.Third.getMatchCount()) {
            return Rank.Third;
        }
        if (matchCount == Rank.Fourth.getMatchCount()) {
            return Rank.Fourth;
        }
        if (matchCount == Rank.Fifth.getMatchCount()) {
            return Rank.Fifth;
        }
        return Rank.MISS;
    }

}
