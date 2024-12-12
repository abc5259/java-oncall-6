package oncall;

import oncall.controller.IteratorInputHandler;
import oncall.controller.IteratorInputTemplate;
import oncall.controller.OnCallController;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallConfig {

    private InputView inputView;
    private OutputView outputView;
    private IteratorInputTemplate iteratorInputTemplate;
    private IteratorInputHandler iteratorInputHandler;
    private OnCallController onCallController;

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public IteratorInputTemplate iteratorInputTemplate() {
        if (iteratorInputTemplate == null) {
            iteratorInputTemplate = new IteratorInputTemplate(outputView());
        }
        return iteratorInputTemplate;
    }

    public IteratorInputHandler iteratorInputHandler() {
        if (iteratorInputHandler == null) {
            iteratorInputHandler = new IteratorInputHandler(inputView(), iteratorInputTemplate());
        }
        return iteratorInputHandler;
    }

    public OnCallController onCallController() {
        if (onCallController == null) {
            onCallController = new OnCallController(iteratorInputHandler(), outputView());
        }
        return onCallController;
    }
}
