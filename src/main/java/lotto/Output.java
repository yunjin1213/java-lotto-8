package lotto;

import java.util.List;
import java.util.Map;

public class Output {

    public void printPurchasedCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    // 로또 번호는 이미 오름차순 정렬된 List<Integer>라고 가정
    public void printLotteries(List<List<Integer>> lotteries) {
        for (List<Integer> numbers : lotteries) {
            System.out.println(numbers);
        }
    }

    public void printWinningStatistics(Map<Rank, Integer> rankCounts) {

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + rankCounts.getOrDefault(Rank.Fifth, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts.getOrDefault(Rank.Fourth, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts.getOrDefault(Rank.Third, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts.getOrDefault(Rank.Second, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts.getOrDefault(Rank.First, 0) + "개");
    }

    public void printProfitRate(double profitRatePercent) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRatePercent);
    }
}
