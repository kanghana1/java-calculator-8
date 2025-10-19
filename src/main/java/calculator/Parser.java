package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    // TODO : 구분자 찾기, 파싱하기 등 문자열에서 구분자와 숫자를 구분하는 역할을 합니다.
    private final List<String> parsers = new ArrayList<>(List.of(",", ":"));


    // TODO : 문자열을 받아 파싱합니다
    public List<Integer> parsing(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("문자열이 입력되지 않았습니다.");
        }

        input = input.replace("\\n","\n");

        // 구분자 더 있는지 확인하기 (커스텀 구분자)
        String parsing = addParser(input);

        for (String op : parsers) {
            parsing = parsing.replace(op, ":");
        }

        List<Integer> results;
        try {
            results = Arrays.stream(parsing.split(":"))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자가 아닌 문자열이 입력되었습니다.");
        }

        return results;
    }


    // TODO : 커스텀 구분자가 입력된 경우와 아닌 경우를 나누어 파싱할 문자열을 반환합니다.
    private String addParser(String input) {
        if ((input.contains("//") && (input.contains("\n")))) {
            return addCustomParser(input);
        } else {
            return input;
        }
    }

    // TODO : 커스텀 구분자가 입력된 경우 구분자를 꺼내어 리스트에 넣습니다.
    private String addCustomParser(String input) {
        int index = input.indexOf("\n");

        if (input.indexOf("//") > index) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        parsers.add(input.substring(2, index));
        return input.substring(index + 1);
    }
}
