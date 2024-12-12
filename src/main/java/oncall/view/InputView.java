package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_WORK_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String INPUT_WORKDAY_WORKERS = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

    public String inputWorkDay() {
        System.out.print(INPUT_WORK_DAY);
        return Console.readLine();
    }

    public String inputWorkdayWorkers() {
        System.out.print(INPUT_WORKDAY_WORKERS);
        return Console.readLine();
    }
}
