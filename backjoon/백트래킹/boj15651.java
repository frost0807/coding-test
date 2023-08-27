package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 기본적인 백트래킹 문제
 * StringBuilder를 이용해 시간단축을 해야한다.
 */
public class boj15651 {
    static int[] result;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        result = new int[m];

        backTrack(0);
        System.out.println(sb);
    }

    static void backTrack(int index) {
        if (index == m) {
            for (int i : result) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            result[index] = i;
            backTrack(index + 1);
        }
    }
}
