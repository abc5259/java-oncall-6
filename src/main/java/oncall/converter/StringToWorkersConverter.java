package oncall.converter;

import java.util.LinkedList;
import java.util.Queue;
import oncall.domain.Worker;

public class StringToWorkersConverter implements Converter<String, Queue<Worker>> {
    @Override
    public Queue<Worker> convert(String source) {
        String[] workNames = source.split(",");
        Queue<Worker> workerQueue = new LinkedList<>();
        for (String name : workNames) {
            workerQueue.offer(new Worker(name));
        }
        return workerQueue;
    }
}
