package lotto;

import java.util.List;

public class RandomNumberCreator {
    public List<Integer> createRandomLottoNumbers() {
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1,45,6);

        return numbers;
    }

    public int createUniqueRandomNumber(List<Integer> excludedNumbers) {
        int number = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 45);

        while(!excludedNumbers.contains(number)){
            number = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 45);
        }

        return number;
    }
}
