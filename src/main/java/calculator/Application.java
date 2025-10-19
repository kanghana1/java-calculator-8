package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        Parser parser = new Parser();
        Calculator calculator = new Calculator(parser.parsing(input.trim()));
        int answer = calculator.sum();

        System.out.println("결과 : " + answer);

    }
}
