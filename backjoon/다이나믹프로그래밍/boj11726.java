package 다이나믹프로그래밍;

import java.util.Scanner;

public class boj11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 3];
        int result;
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 10007;
        }
        result = d[n];
        System.out.println(result);
    }
}
