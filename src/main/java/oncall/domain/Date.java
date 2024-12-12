package oncall.domain;

public record Date(
        Month month,
        int dayInMonth,
        Day day
) {
    public Date {
        if (month.isBelongToDayInMonth(dayInMonth)) {
            throw new IllegalArgumentException("잘못된 날짜입니다.");
        }
    }
}
