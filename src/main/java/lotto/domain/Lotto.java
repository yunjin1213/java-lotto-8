package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::contains)
                .count();
    }
}

