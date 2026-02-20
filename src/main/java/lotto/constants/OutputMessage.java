package lotto.constants;

public enum OutputMessage {
    PURCHASE_COUNT_MESSAGE("\n%d개를 구매했습니다.\n"),
    WINNING_STATISTICS_HEADER("\n당첨 통계\n---"),
    YIELD_MESSAGE("총 수익률은 %.1f%%입니다.\n"),
    NORMAL_RANK_FORMAT("%d개 일치 (%,d원) - %d개\n"),
    SECOND_RANK_FORMAT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
