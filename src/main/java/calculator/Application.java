package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Application {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = br.readLine();

            Parser parser = new Parser();
            Calculator calculator = new Calculator(parser.parsing(input.trim()));
            int answer = calculator.sum();

            System.out.println("결과 : " + answer);
        } catch (IOException e) {
            throw new RuntimeException("BufferedReader 오류 발생", e);
        }
    }
}
