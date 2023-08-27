package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 문자열
 * <p>
 * 문자열 잘라서 HashMap으로 중복값 검증하는 문제
 */
public class boj1235 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = bf.readLine();
        }
        int length = numbers[0].length();
        outer:
        for (int i = 1; i <= length; i++) {
            HashMap<String, Boolean> numberMap = new HashMap<>();
            for (String number : numbers) {
                String currentString = number.substring(length - i, length);
                if (numberMap.containsKey(currentString)) {
                    continue outer;
                }
                numberMap.put(currentString, true);
            }
            result = i;
            break;
        }
        System.out.println(result);
    }
}
