package 다이나믹프로그래밍;

import java.util.Scanner;

public class boj9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] d = new int[n + 4];
            d[1] = 1;
            d[2] = 2;
            d[3] = 4;

            for (int j = 4; j <= n; j++) {
                d[j] += d[j - 1] + d[j - 2] + d[j - 3];
            }
            result[i] = d[n];
        }
        for (int i : result) {
            System.out.println(i);
        }
    }
}
