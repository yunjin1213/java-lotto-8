package lotto;

import java.util.List;

public class RandomNumberCreator {
    public List<Integer> createRandomLottoNumbers() {
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(Lotto.MINIMUM_NUMBER,Lotto.MAXIMUM_NUMBER,Lotto.NUMBERS_COUNT);

        return numbers;
    }
}
