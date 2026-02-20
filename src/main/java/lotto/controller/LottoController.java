package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine; // 의존성 주입받을 도메인

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        try {
            int purchaseAmount = inputView.readPurchaseAmount();
            List<Lotto> purchasedLottos = lottoMachine.buyLottos(purchaseAmount);
            outputView.printPurchasedLottos(purchasedLottos);

            List<Integer> winningNumbers = inputView.readWinningNumbers();
            Lotto winningLottoNumbers = new Lotto(winningNumbers);

            int bonusNumber = inputView.readBonusNumber();
            WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

            LottoResult lottoResult = new LottoResult();
            lottoResult.compareLottos(purchasedLottos, winningLotto);

            outputView.printWinningStatistics(lottoResult);
            double yield = lottoResult.calculateYield(purchaseAmount);
            outputView.printTotalYield(yield);

        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }
}
