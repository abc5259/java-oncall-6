package oncall.domain;

import java.util.Arrays;

public enum Day {
    MON("월"), THU("화"), WES("수"), TUR("목"), FRI("금"), SAT("토"), SUN("일");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public static Day findByName(String name) {
        return Arrays.stream(Day.values())
                .filter(day -> day.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 요일 이름입니다."));
    }
}
