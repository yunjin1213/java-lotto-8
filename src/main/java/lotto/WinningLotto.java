package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateDuplicationInNumbers();
        validateDuplicatedBonusNumberInNumbers();

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicationInNumbers() {
        for (int i = 0; i < numbers.size() -1; i++) {
            List<Integer> restNumbers = numbers.subList(i + 1, numbers.size() - 1);
            for (int number : numbers) {
                if (restNumbers.contains(number)) {
                    throw new IllegalArgumentException("[ERROR] 중복되는 번호가 있을 수 없습니다.");
                }
            }
        }

    }

    private void validateDuplicatedBonusNumberInNumbers() {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 숫자들과 겹칠 수 없습니다.");
        }
    }
}
