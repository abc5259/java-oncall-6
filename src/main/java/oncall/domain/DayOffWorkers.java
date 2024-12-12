package oncall.domain;

import java.util.HashSet;
import java.util.Queue;

public class DayOffWorkers {

    private final Queue<Worker> workers;

    public DayOffWorkers(WeekdayWorkers weekdayWorkers, Queue<Worker> workers) {
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
}
