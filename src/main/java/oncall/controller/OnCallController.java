package oncall.controller;


import java.util.Map;
import oncall.domain.Calendar;
import oncall.domain.Date;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.view.OutputView;

public class OnCallController {


    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public OnCallController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process() {
        Date date = iteratorInputHandler.inputFirstWorkDays();
        Workers workers = iteratorInputHandler.inputWorkers();

        Calendar calendar = new Calendar(date);
        Map<Date, Worker> assignment = workers.assignment(calendar);
        outputView.printWorkerInfos(assignment);
    }
}
