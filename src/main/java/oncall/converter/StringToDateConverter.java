package oncall.converter;

import oncall.domain.Date;
import oncall.domain.Day;
import oncall.domain.Month;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        String[] workDays = source.split(",");
        if (workDays.length != 2) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
        int month = new StringToIntConverter().convert(workDays[0].trim());
        Day day = Day.findByName(workDays[1].trim());
        return new Date(Month.findBySymbol(month), 1, day);
    }
}
