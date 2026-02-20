package lotto.view;

import lotto.constants.OutputMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(OutputMessage.PURCHASE_COUNT_MESSAGE.getMessage(), lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatistics(LottoResult lottoResult) {
        System.out.println(OutputMessage.WINNING_STATISTICS_HEADER.getMessage());
        Map<Rank, Integer> result = lottoResult.getResult();

        printRankCondition(Rank.FIFTH, result.getOrDefault(Rank.FIFTH, 0));
        printRankCondition(Rank.FOURTH, result.getOrDefault(Rank.FOURTH, 0));
        printRankCondition(Rank.THIRD, result.getOrDefault(Rank.THIRD, 0));
        printRankCondition(Rank.SECOND, result.getOrDefault(Rank.SECOND, 0));
        printRankCondition(Rank.FIRST, result.getOrDefault(Rank.FIRST, 0));
    }

    private void printRankCondition(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            System.out.printf(OutputMessage.SECOND_RANK_FORMAT.getMessage(),
                    rank.getMatchCount(), rank.getPrizeMoney(), count);
            return;
        }
        System.out.printf(OutputMessage.NORMAL_RANK_FORMAT.getMessage(),
                rank.getMatchCount(), rank.getPrizeMoney(), count);
    }

    public void printTotalYield(double yield) {
        System.out.printf(OutputMessage.YIELD_MESSAGE.getMessage(), yield);
    }

    public void printErrorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
