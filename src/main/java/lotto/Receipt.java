package lotto;

import java.util.List;

public class Receipt {
    public static final int LOTTO_PRICE = 1000;

    private int amountOfMoney;
    private int amountOfLotteries;

    public Receipt(int amountOfMoney, int amountOfLotteries) {
        this.amountOfMoney = amountOfMoney;
        this.amountOfLotteries = amountOfLotteries;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public int getAmountOfLotteries() {
        return amountOfLotteries;
    }
}
