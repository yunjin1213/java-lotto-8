package lotto;

public enum Rank {
    First(6, false, 2000000000,"6개 일치 - 1등"),
    Second(5, true, 30000000, "5개 일치 + 보너스 일치 - 2등"),
    Third(5, false, 1500000, "5개 일치 + 보너스 불일치 - 3등"),
    Fourth(4, false, 50000, "4개 일치 - 4등"),
    Fifth(3,false, 5000, "3개 일치 - 5등"),
    MISS(0, false, 0,""); // 굳이?


    private final int matchCount;
    private final boolean requiresBonus;
    private final long prize;
    private final String message;

    Rank(int matchCount, boolean requiresBonus, long prize, String message) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
        this.message = message;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
