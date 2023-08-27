package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * backTracking문제
 * 메소드의 첫번째 인자로 result에 채울 index,
 * 두번째 인자로 result에 채워진 숫자 중 가장 큰 수를 전달해서 오름차순으로 result에 입력
 */
public class boj15650 {
    static int m;
    static int n;
    static int[] result;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        result = new int[m];
        isUsed = new boolean[n + 1];

        backTrack(0, 0);
    }

    static void backTrack(int indexToBeFilled, int biggestUsedIndex) {
        if (indexToBeFilled == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : result) sb.append(i + " ");
            System.out.println(sb);
            return;
        }
        for (int i = biggestUsedIndex + 1; i <= n; i++) {
            result[indexToBeFilled] = i;
            isUsed[i] = true;
            backTrack(indexToBeFilled + 1, i);
            isUsed[i] = false;
        }
    }
}
