package oncall.domain;

public class Workers {

    private final WeekdayWorkers weekdayWorkers;
    private final DayOffWorkers dayOffWorkers;

    public Workers(WeekdayWorkers weekdayWorkers, DayOffWorkers dayOffWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.dayOffWorkers = dayOffWorkers;
    }
}
