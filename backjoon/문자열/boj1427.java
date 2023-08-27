package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문자열, 정렬
 * <p>
 * 문자열을 1개씩 분리해 int로 변환 후 배열에 저장한 후 정렬 후 출력
 */
public class boj1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split("");
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int i = numbers.length - 1; i >= 0; i--) {
            sb.append(numbers[i]);
        }
        System.out.println(sb);
    }
}
