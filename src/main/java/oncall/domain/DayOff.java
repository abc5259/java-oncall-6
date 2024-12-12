package oncall.domain;

public enum DayOff {
    신정(1, 1),
    삼일절(3, 1),
    어린이날(5, 5),
    현충일(6, 6),
    광복절(8, 15),
    개천절(10, 3),
    한글날(10, 9),
    성탄일(12, 25),
    ;

    private final int month;
    private final int dayInMonth;

    DayOff(int month, int dayInMonth) {
        this.month = month;
        this.dayInMonth = dayInMonth;
    }
}
