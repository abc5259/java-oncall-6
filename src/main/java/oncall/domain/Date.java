package oncall.domain;

public record Date(
        int month,
        int dayInMonth,
        Day day
) {
}
