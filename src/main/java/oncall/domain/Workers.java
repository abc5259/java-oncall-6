package oncall.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Workers {

    private final WeekdayWorkers weekdayWorkers;
    private final DayOffWorkers dayOffWorkers;

    public Workers(WeekdayWorkers weekdayWorkers, DayOffWorkers dayOffWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.dayOffWorkers = dayOffWorkers;
    }

    public Map<Date, Worker> assignment(Calendar calendar) {
        List<Date> dates = calendar.getDates();
        Map<Date, Worker> workerInfos = new LinkedHashMap<>();
        Worker prevWorker = null;
        for (Date date : dates) {
            if (prevWorker != null && prevWorker.equals(nextWorker(date))) {
                changeSequenceWorker(date);
            }

            Worker worker = pollWorker(date);
            workerInfos.put(date, worker);
            prevWorker = worker;
        }

        return workerInfos;
    }

    private Worker pollWorker(Date date) {
        if (date.isDayOff()) {
            return dayOffWorkers.pollWorker();
        }
        return weekdayWorkers.pollWorker();
    }

    private Worker nextWorker(Date date) {
        if (date.isDayOff()) {
            return dayOffWorkers.nextWorker();
        }
        return weekdayWorkers.nextWorker();
    }

    private void changeSequenceWorker(Date date) {
        if (date.isDayOff()) {
            dayOffWorkers.changeSequence();
        }
        weekdayWorkers.changeSequence();
    }
}
