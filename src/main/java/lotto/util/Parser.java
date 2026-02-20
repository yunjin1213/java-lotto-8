package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static int parsePurchaseAmount(String input) {
        return parseToInt(input);
    }

    public static List<Integer> parseWinningNumbers(String input) {
        InputValidator.validateEmpty(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Parser::parseToInt) // 내부 비공개 메서드 재사용
                .collect(Collectors.toList());
    }

    public static int parseBonusNumber(String input) {
        return parseToInt(input);
    }

    private static int parseToInt(String input) {
        InputValidator.validateEmpty(input);
        InputValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }
}
