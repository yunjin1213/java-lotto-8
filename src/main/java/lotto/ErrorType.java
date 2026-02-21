package lotto;

public enum ErrorType {

    DUPLICATED_NUMBERS("[ERROR] 중복된 숫자는 허용되지 않습니다"),
    LOTTO_COUNTS("[ERROR] 로또 번호는 6개여야 합니다."),
    WRONG_AMOUNT_OF_MONEY("[ERROR] 금액은 1000원 단위여야 합니다.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }
}
