package lotto.util;

import lotto.constants.ErrorMessage;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public static void validateNumeric(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getMessage());
        }
    }
}
