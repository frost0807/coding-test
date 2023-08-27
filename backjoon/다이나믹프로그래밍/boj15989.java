package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader와 StringBuilder를 사용해 실행시간을 줄이고,
 * 배열을 적게 사용해 공간복잡도를 줄이는 문제
 */
public class boj15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int[] nArray = new int[10001];
        for (int i = 0; i < n; i++) {
            nArray[Short.parseShort(bf.readLine())]++;
        }
        for (int i = 1; i < 10001; i++) {
            if (nArray[i] > 0) {
                for (int j = 0; j < nArray[i]; j++) {
                    sb.append(i + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
