package calculator;

import java.util.List;

public class Calculator {

    // TODO : 파싱한 숫자로 덧셈 연산을 합니다.
    private List<Integer> ops;


    public Calculator(List<Integer> ops) {
        this.ops = ops;
    }

    // TODO : 전달받은 int 리스트를 모두 더해줍니다.
    public int sum() {
        int sum = 0;
        for (int op : ops) {
            if (op <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
            sum += op;
        }
        return sum;
    }
}
