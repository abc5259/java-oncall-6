package oncall.controller;

import oncall.converter.StringToDateConverter;
import oncall.converter.StringToWeekdayWorkersConverter;
import oncall.domain.Date;
import oncall.domain.WeekdayWorkers;
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
}
