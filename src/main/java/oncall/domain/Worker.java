package oncall.domain;

public class Worker {

    private final String name;

    public Worker(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름을 입력하세요.");
        }
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자여야 합니다.");
        }
        this.name = name.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Worker crew = (Worker) o;
        return name.equals(crew.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
