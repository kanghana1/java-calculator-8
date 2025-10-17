package calculator;

import javax.print.attribute.standard.Finishings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
            int answer = calculate(input);
            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException("BufferedReader 오류 발생", e);
        }
    }

}
