package oncall.domain;

import java.util.Deque;
import java.util.HashSet;

public class WeekdayWorkers {

    private final Deque<Worker> workers;

    public WeekdayWorkers(Deque<Worker> workers) {
        if (workers.size() > new HashSet<>(workers).size()) {
            throw new IllegalArgumentException("중복된 근무자가 있습니다.");
        }
        if (workers.size() < 5 || workers.size() > 35) {
            throw new IllegalArgumentException("근무자 인원은 5명에서 35명까지 가능합니다.");
        }
        this.workers = workers;
    }

    public boolean containsAll(Deque<Worker> workers) {
        return this.workers.containsAll(workers);
    }

    public boolean isSameSize(int size) {
        return this.workers.size() == size;
    }

    public Worker pollWorker() {
        Worker worker = workers.pollFirst();
        workers.offerLast(worker);
        return worker;
    }

    public Worker nextWorker() {
        return workers.peekFirst();
    }

    public void changeSequence() {
        Worker worker1 = workers.pollFirst();
        Worker worker2 = workers.pollFirst();
        workers.offerFirst(worker1);
        workers.offerFirst(worker2);
    }
}
