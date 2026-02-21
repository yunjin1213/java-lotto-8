package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int NUMBERS_COUNT = 6;

    // TODO: Lotto랑 WinningLotto가 유사한 면이 있음. abstract class나 interface를 사용하는 것을 고민해봐야 함.

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplication();
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchWinningNumbers(List<Integer> winningNumbers) {
        int count = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean matchBonusNumber(int bonusNumber) {
        for(int number : numbers){
            if(number == bonusNumber){
                return true;
            }
        }

        return false;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication() {
        for (int i = 0; i < numbers.size() -1 ; i++) {
            List<Integer> restNumbers = numbers.subList(i + 1, numbers.size() -1);
            if (restNumbers.contains(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 겹치는 로또 번호가 있습니다.");
            }
        }
    }

}
