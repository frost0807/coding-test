package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 브루트포스
 * 각 사람에 대해서 모든 사람에 대한 등수를 책정하는 이중 for-loop
 */
public class boj7568 {
    public static void main(String[] args) throws IOException {
        int rank;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] mass = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split(" ");
            mass[i][0] = Integer.parseInt(input[0]);
            mass[i][1] = Integer.parseInt(input[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int[] selectedP : mass) {
            rank = 1;
            for (int[] comparedP : mass) {
                if (selectedP[0] < comparedP[0] && selectedP[1] < comparedP[1]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}
