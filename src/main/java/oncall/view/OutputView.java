package oncall.view;

import java.util.Map;
import oncall.domain.Date;
import oncall.domain.Worker;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }

    public void printWorkerInfos(Map<Date, Worker> workerInfos) {
        System.out.println();
        workerInfos.forEach(
                (date, worker) ->
                {
                    if (date.isWeekdayDayOff()) {
                        System.out.printf(
                                "%d월 %d일 %s(휴일) %s%n",
                                date.month().getSymbol(),
                                date.dayInMonth(),
                                date.day().getName(),
                                worker.getName());
                        return;
                    }
                    System.out.printf(
                            "%d월 %d일 %s %s%n",
                            date.month().getSymbol(),
                            date.dayInMonth(),
                            date.day().getName(),
                            worker.getName());
                });
    }
}
