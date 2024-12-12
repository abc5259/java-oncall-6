package oncall.controller;


import oncall.view.OutputView;

public class OnCallController {


    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public OnCallController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process() {

    }
}