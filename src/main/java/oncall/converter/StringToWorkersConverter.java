package oncall.converter;

import java.util.ArrayDeque;
import java.util.Deque;
import oncall.domain.Worker;

public class StringToWorkersConverter implements Converter<String, Deque<Worker>> {
    @Override
    public Deque<Worker> convert(String source) {
        String[] workNames = source.split(",");
        Deque<Worker> workerQueue = new ArrayDeque<>();
        for (String name : workNames) {
            workerQueue.offer(new Worker(name));
        }
        return workerQueue;
    }
}
