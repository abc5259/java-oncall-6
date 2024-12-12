package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private final List<Date> dates;

    public Calendar(Date startDate) {
        List<Date> dates = new ArrayList<>();
        while (startDate.isValidDayInMonth()) {
            dates.add(startDate);
            startDate = startDate.nextDate();
        }
        this.dates = dates;
    }
}
