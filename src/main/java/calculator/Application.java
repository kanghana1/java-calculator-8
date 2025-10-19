package calculator;

import javax.print.attribute.standard.Finishings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
            int answer = calculate(input);
            System.out.println("결과 : " + answer);
        } catch (IOException e) {
            throw new RuntimeException("BufferedReader 오류 발생", e);
        }
    }
    private static int calculate(String input) {
        int sum = 0;
        List<Integer> ops = parsing(input);
        for (int num : ops) {
            if (num <= 0) throw new IllegalArgumentException("양수만 입력이 가능합니다.");
            sum += num;
        }
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
        List<Integer> results = new ArrayList<>();
        int index = input.replace("\\n","\n").indexOf("\n");
        String parsing = input.substring(index + 2);
        String parser = input.substring(2, index - 1);

        for (String str : parsing.split(Pattern.quote(parser))) {
            System.out.println(str);
            results.add(Integer.valueOf(str));
        }

        return results;
    }

    private static List<Integer> basicParsing(String input) {
        List<Integer> results = new ArrayList<>();
        String[] parsingToComma;
        String[] parsingToColon;

        boolean containsComma = input.contains(",");
        boolean containsColon = input.contains(":");

        if (containsComma && containsColon) {
            // ,와 : 모두 있는 경우
            parsingToComma = input.split(",");
            for (String str : parsingToComma) {
                for (String fin : str.split(":")) {
                    results.add(Integer.valueOf(fin));
                }
            }
        } else if (containsColon) { // 2. :만 있는 경우
            parsingToColon = input.split(":");
            for (String fin : parsingToColon) {
                results.add(Integer.valueOf(fin));
            }
        } else if (containsComma) { // 3. ,만 있는 경우
            parsingToComma = input.split(",");
            for (String fin : parsingToComma) {
                results.add(Integer.valueOf(fin));
            }
        }

        return results;
    }
}
