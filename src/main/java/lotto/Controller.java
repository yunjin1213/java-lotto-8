package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    // input / output과 service 연결
    private Input input = new Input();
    private Output output = new Output();
    private Service service = new Service();

    public void run() {
        Receipt receipt = createReceipt();
        int amountOfLotteries = receipt.getAmountOfLotteries();
        List<Lotto> lotteries = createLotteries(amountOfLotteries);

        WinningLotto winningLotto = createWinningLotto();

        Map<Rank, Integer> rankCounts = createRankCount(winningLotto, lotteries);
        Result result = createResult(rankCounts, receipt);

        showProfitRate(result);
    }

    private Receipt createReceipt() {
        int purchaseAmount = input.readPurchaseAmount();
        Receipt receipt = service.createReceipt(purchaseAmount);

        int amountOfLotteries = receipt.getAmountOfLotteries();
        output.printPurchasedCount(amountOfLotteries);

        return receipt;
    }

    private List<Lotto> createLotteries(int amountOfLotteries) {
        List<Lotto> lotteries = service.createLotteries(amountOfLotteries);
        List<List<Integer>> lotteryNumbers = new ArrayList<>();

        for (Lotto lotto : lotteries) {
            lotteryNumbers.add(lotto.getNumbers());
        }

        output.printLotteries(lotteryNumbers);

        return lotteries;
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = input.readWinningNumbers();
        int bonusNumber = input.readBonusNumber();

        return service.createWinningLotto(winningNumbers, bonusNumber);
    }

    private Map<Rank, Integer> createRankCount(WinningLotto winningLotto, List<Lotto> lotteries) {
        //굳이 이긴 하다..
        Map<Rank, Integer> rankCounts = service.createRankCounts(winningLotto, lotteries);
        output.printWinningStatistics(rankCounts);

        return rankCounts;
    }

    private Result createResult(Map<Rank, Integer> rankCount,Receipt receipt) {
        int amountOfMoney = receipt.getAmountOfMoney();
        return service.createResult(rankCount, amountOfMoney);
    }

    private void showProfitRate(Result result) {
        output.printProfitRate(result.profitRate);
    }


}
