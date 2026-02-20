package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public List<Lotto> buyLottos(int money) {
        validateMoney(money);
        int count = money / LottoRule.TICKET_PRICE;
        return generateLottos(count);
    }

    private void validateMoney(int money) {
        if (money <= 0 || money % LottoRule.TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateSingleLotto());
        }
        return lottos;
    }

    private Lotto generateSingleLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoRule.MIN_NUMBER,
                LottoRule.MAX_NUMBER,
                LottoRule.LOTTO_SIZE
        );

        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return new Lotto(sortedNumbers);
    }
}