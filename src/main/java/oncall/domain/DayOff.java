package oncall.domain;

import static oncall.domain.Month.AUGUST;
import static oncall.domain.Month.DECEMBER;
import static oncall.domain.Month.JANUARY;
import static oncall.domain.Month.JUNE;
import static oncall.domain.Month.MARCH;
import static oncall.domain.Month.MAY;
import static oncall.domain.Month.OCTOBER;

import java.util.Arrays;

public enum DayOff {
    신정(JANUARY, 1),
    삼일절(MARCH, 1),
    어린이날(MAY, 5),
    현충일(JUNE, 6),
    광복절(AUGUST, 15),
    개천절(OCTOBER, 3),
    한글날(OCTOBER, 9),
    성탄일(DECEMBER, 25),
    ;

    private final Month month;
    private final int dayInMonth;

    DayOff(Month month, int dayInMonth) {
        this.month = month;
        this.dayInMonth = dayInMonth;
    }

    public static boolean contains(Month month, int dayInMonth) {
        return Arrays.stream(DayOff.values())
                .anyMatch(dayOff -> dayOff.month == month && dayOff.dayInMonth == dayInMonth);
    }
}
