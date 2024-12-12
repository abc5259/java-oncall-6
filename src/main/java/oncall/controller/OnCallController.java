package oncall.controller;


import oncall.domain.Calendar;
import oncall.domain.Date;
import oncall.domain.WeekdayWorkers;
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
        WeekdayWorkers weekdayWorkers = iteratorInputHandler.inputWeekdayWorkers();
        
        Calendar calendar = new Calendar(date);
    }
}
