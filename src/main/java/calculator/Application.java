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
    private static int calculate(String input) {
        int sum = 0;
        List<Integer> ops = parsing(input);
        for (int num : ops) sum += num;
        return sum;
    }

    private static List<Integer> parsing(String input) {
        if (!input.contains("//")) {
            return basicParsing(input);
        } else {
            return customParsing(input);
        }
    }

    private static List<Integer> customParsing(String input) {

        return null;
    }

    private static List<Integer> basicParsing(String input) {
        List<Integer> results = new ArrayList<>();
        String[] parsingToComma;
        String[] parsingToColon;

        boolean containsComma = input.contains(",");
        boolean containsColon = input.contains(":");

        if (containsComma) {
            parsingToComma = input.split(",");

            // 1. ,와 :이 둘 다 있는 경우
            if (containsColon) {
                for (String str : parsingToComma) {
                    parsingToColon = str.split(":");

                    for (String fin : parsingToColon) {
                        results.add(Integer.valueOf(fin));
                    }
                }
            } else { // 2. ,만 있는 경우
                for (String fin : parsingToComma) {
                    results.add(Integer.valueOf(fin));
                }
            }
        } else if (containsColon) { // 3. :만 있는 경우
            parsingToColon = input.split(":");
            for (String fin : parsingToColon) {
                results.add(Integer.valueOf(fin));
            }
        }

        return results;
    }
}
