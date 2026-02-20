package lotto.constants;

public enum ErrorMessage {
    INVALID_SIZE("로또 번호는 " + LottoRule.LOTTO_SIZE + "개여야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다."),
    INVALID_RANGE("로또 번호는 " + LottoRule.MIN_NUMBER + "부터 " + LottoRule.MAX_NUMBER + " 사이여야 합니다."),
    INVALID_MONEY("로또 구입 금액은 " + LottoRule.TICKET_PRICE + "원 단위여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    EMPTY_INPUT("입력값이 비어있습니다."),
    NOT_NUMERIC("숫자만 입력해 주세요.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
