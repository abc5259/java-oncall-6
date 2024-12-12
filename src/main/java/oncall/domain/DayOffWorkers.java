package oncall.domain;

import java.util.Deque;
import java.util.HashSet;

public class DayOffWorkers {

    private final Deque<Worker> workers;

    public DayOffWorkers(WeekdayWorkers weekdayWorkers, Deque<Worker> workers) {
        if (workers.size() > new HashSet<>(workers).size()) {
            throw new IllegalArgumentException("중복된 근무자가 있습니다.");
        }
        if (workers.size() < 5 || workers.size() > 35) {
            throw new IllegalArgumentException("근무자 인원은 5명에서 35명까지 가능합니다.");
        }
        if (!weekdayWorkers.containsAll(workers) || !weekdayWorkers.isSameSize(workers.size())) {
            throw new IllegalArgumentException("평일 근무자중 휴일 근무를 하지 않는 근무자가 있습니다.");
        }
        this.workers = workers;
    }

    public Worker pollWorker() {
        Worker worker = workers.poll();
        workers.offer(worker);
        return worker;
    }

    public Worker nextWorker() {
        return workers.peekFirst();
    }

    public void changeSequence() {
        Worker worker1 = workers.pollFirst();
        Worker worker2 = workers.pollFirst();
        workers.offerFirst(worker2);
        workers.offerFirst(worker1);
    }
}
