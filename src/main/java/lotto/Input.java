package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        int amountOfMoney = Integer.parseInt(input);

        if (amountOfMoney % Receipt.LOTTO_PRICE !=0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        return amountOfMoney;
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력이 올바르지 않습니다.");
        }

        String[] tokens = input.split(",");
        if (tokens.length != Lotto.NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            String value = token.trim();
            if (!value.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
            numbers.add(Integer.parseInt(value));
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            List<Integer> restNumbers = numbers.subList(i + 1, numbers.size() - 1);

            if (restNumbers.contains(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호들은 중복되면 안됩니다.");
            }
        }

        return numbers;
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        return Integer.parseInt(input);
    }

}
