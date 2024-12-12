package oncall.controller;

import java.util.Queue;
import oncall.converter.StringToDateConverter;
import oncall.converter.StringToWeekdayWorkersConverter;
import oncall.converter.StringToWorkersConverter;
import oncall.domain.Date;
import oncall.domain.DayOffWorkers;
import oncall.domain.WeekdayWorkers;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.view.InputView;

public class IteratorInputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }

    public Date inputFirstWorkDays() {
        return iteratorInputTemplate.execute(
                inputView::inputWorkDay,
                new StringToDateConverter()
        );
    }

    public WeekdayWorkers inputWeekdayWorkers() {
        return iteratorInputTemplate.execute(
                inputView::inputWorkdayWorkers,
                new StringToWeekdayWorkersConverter()
        );
    }

    public DayOffWorkers inputDayOffWorkers(WeekdayWorkers weekdayWorkers) {
        return iteratorInputTemplate.execute(
                inputView::inputDayOffWorkers,
                (value) -> {
                    Queue<Worker> workers = new StringToWorkersConverter().convert(value);
                    return new DayOffWorkers(weekdayWorkers, workers);
                }
        );
    }

    public Workers inputWorkers() {
        return iteratorInputTemplate.execute(
                inputView::inputWorkdayWorkers,
                value -> {
                    StringToWorkersConverter stringToWorkersConverter = new StringToWorkersConverter();
                    Queue<Worker> workers = stringToWorkersConverter.convert(value);
                    WeekdayWorkers weekdayWorkers = new WeekdayWorkers(workers);

                    String dayOffWorkerNames = inputView.inputDayOffWorkers();
                    DayOffWorkers dayOffWorkers = new DayOffWorkers(
                            weekdayWorkers, stringToWorkersConverter.convert(dayOffWorkerNames));
                    return new Workers(weekdayWorkers, dayOffWorkers);
                }
        );
    }
}
