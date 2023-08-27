package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열
 * <p>
 * 1덩어리와 0덩어리의 수를 비교한 후 더 적은값은 출력
 */
public class boj1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int zeroCount = 0;
        int oneCount = 0;
        boolean isValueZero = false;
        String input = bf.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (i == 0 && input.charAt(i) == '0') {
                zeroCount++;
                isValueZero = true;
                continue;
            }
            if (i == 0 && input.charAt(i) == '1') {
                oneCount++;
                isValueZero = false;
                continue;
            }
            if (isValueZero && input.charAt(i) == '1') {
                oneCount++;
                isValueZero = false;
                continue;
            }
            if (!isValueZero && input.charAt(i) == '0') {
                zeroCount++;
                isValueZero = true;
            }
        }
        System.out.println(Math.min(zeroCount, oneCount));
    }
}
