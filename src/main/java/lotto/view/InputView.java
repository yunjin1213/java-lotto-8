package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputMessage;
import lotto.util.Parser;
import java.util.List;

public class InputView {

    public int readPurchaseAmount() {
        System.out.println(InputMessage.REQUEST_PURCHASE_AMOUNT.getMessage());
        String input = Console.readLine();
        return Parser.parsePurchaseAmount(input);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(InputMessage.REQUEST_WINNING_NUMBERS.getMessage());
        String input = Console.readLine();
        return Parser.parseWinningNumbers(input);
    }

    public int readBonusNumber() {
        System.out.println(InputMessage.REQUEST_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        return Parser.parseBonusNumber(input);
    }
}
