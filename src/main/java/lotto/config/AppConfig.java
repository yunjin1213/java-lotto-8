package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), lottoMachine());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private LottoMachine lottoMachine() {
        return new LottoMachine();
    }
}
