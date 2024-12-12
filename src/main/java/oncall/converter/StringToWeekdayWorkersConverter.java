package oncall.converter;

import java.util.LinkedList;
import java.util.Queue;
import oncall.domain.WeekdayWorkers;
import oncall.domain.Worker;

public class StringToWeekdayWorkersConverter implements Converter<String, WeekdayWorkers> {
    @Override
    public WeekdayWorkers convert(String source) {
        String[] workNames = source.split(",");
        Queue<Worker> workerQueue = new LinkedList<>();
        for (String name : workNames) {
            workerQueue.offer(new Worker(name));
        }
        return new WeekdayWorkers(workerQueue);
    }
}
