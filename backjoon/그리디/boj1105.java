package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 그리디
 * <p>
 * 자리수가 다르면 8이 없는 숫자를 만들 수 있고,
 * 자리수가 같을때는 연속해서 같은 자리가 8로 같을 때만 8을 count하고 다른 경우가 나오면 break
 */
public class boj1105 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        String low = input[0];
        String high = input[1];
        if (low.length() == high.length()) {
            for (int i = 0; i < high.length(); i++) {
                if (high.charAt(i) != low.charAt(i)) {
                    break;
                }
                if (high.charAt(i) == '8') {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
