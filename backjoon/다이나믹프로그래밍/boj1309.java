package 다이나믹프로그래밍;

import java.util.Scanner;

/**
 * Dynamic programming
 */
public class boj1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        /**
         * d[i][0] 세로 i번째 우리에 아무 사자도 배치하지 않는 경우의 수
         * d[i][1] 세로 i번째 우리 가로 1번째 우리에 배치하는 경우의 수
         * d[i][2] 세로 i번째 우리 가로 2번째 우리에 배치하는 경우의 수
         * */
        int[][] d = new int[N + 2][3];
        d[1][0] = 1;
        d[1][1] = 1;
        d[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % 9901;
            d[i][1] = (d[i - 1][0] + d[i - 1][2]) % 9901;
            d[i][2] = (d[i - 1][0] + d[i - 1][1]) % 9901;
        }
        System.out.println((d[N][0] + d[N][1] + d[N][2]) % 9901);
    }
}
