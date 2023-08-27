package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 그리디
 * <p>
 * 삼각형의 조건 -> 작은 2 변의 크기의 합이 큰 변의 크기보다 커야 삼각형이 성립한다는 성질을 이용
 */
public class boj1448 {
    public static void main(String[] args) throws IOException {
        int result = -1;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] straws = new int[n];
        for (int i = 0; i < n; i++) {
            straws[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(straws);
        for (int i = n - 1; i > 1; i--) {
            if (straws[i] < straws[i - 1] + straws[i - 2]) {
                result = straws[i] + straws[i - 1] + straws[i - 2];
                break;
            }
        }
        System.out.println(result);
    }
}
