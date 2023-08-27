package 다이나믹프로그래밍;

import java.util.Scanner;

/**
 * Prefix sum
 * Dynamic Programmming
 */
public class boj11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] result = new int[M];
        //d[i]는 1번째 수 부터 i번째 수 까지 더한 값
        int[] d = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            d[i] = d[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            result[i] = d[to] - d[from - 1];
        }
        for (int i : result) {
            System.out.println(i);
        }
    }
}
