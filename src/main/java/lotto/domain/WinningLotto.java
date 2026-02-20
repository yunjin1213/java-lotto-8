package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber < LottoRule.MIN_NUMBER || bonusNumber > LottoRule.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public Rank match(Lotto userLotto) {
        int matchCount = userLotto.countMatchingNumbers(winningLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }
}
