package oncall.domain;

public record Date(
        Month month,
        int dayInMonth,
        Day day
) {
    public Date nextDate() {
        return new Date(month, dayInMonth + 1, day.nextDay());
    }

    public boolean isValidDayInMonth() {
        return month.isBelongToDayInMonth(dayInMonth);
    }

    public boolean isDayOff() {
        return day.isDayOff() || DayOff.contains(month, dayInMonth);
    }

    public boolean isWeekdayDayOff() {
        return !day.isDayOff() && DayOff.contains(month, dayInMonth);
    }
}
