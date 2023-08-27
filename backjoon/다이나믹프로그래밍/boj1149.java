package 다이나믹프로그래밍;

import java.util.Scanner;

public class boj1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] d = new int[N + 2][4];
        int[][] score = new int[N + 2][4];
        int result;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                score[i][j] = sc.nextInt();
            }
        }

        d[1][1] = score[1][1];
        d[1][2] = score[1][2];
        d[1][3] = score[1][3];

        for (int i = 2; i <= N; i++) {
            d[i][1] = score[i][1] + Math.min(d[i - 1][2], d[i - 1][3]);
            d[i][2] = score[i][2] + Math.min(d[i - 1][1], d[i - 1][3]);
            d[i][3] = score[i][3] + Math.min(d[i - 1][1], d[i - 1][2]);
        }

        result = Math.min(Math.min(d[N][1], d[N][2]), d[N][3]);

        System.out.println(result);
    }
}
