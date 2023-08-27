package 다이나믹프로그래밍;

import java.util.Scanner;

/**
 * Dynamic programming
 */
public class boj12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //d[i] = 숫자 i를 1로 만드는데 필요한 횟수의 최솟값
        int[] d = new int[N + 2];
        //numbers[i] = 숫자 i를 최소한의 횟수로 1로 만들 때, i를 연산해 얻은 다음 값
        int[] numbers = new int[N + 2];
        d[1] = 0;
        numbers[1] = 0;

        for (int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + 1;
            numbers[i] = i - 1;

            if (i % 3 == 0) {
                if (d[i] > d[i / 3] + 1) {
                    d[i] = d[i / 3] + 1;
                    numbers[i] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (d[i] > d[i / 2] + 1) {
                    d[i] = d[i / 2] + 1;
                    numbers[i] = i / 2;
                }
            }
        }
        System.out.println(d[N]);
        while (N != 0) {
            System.out.print(N + " ");
            N = numbers[N];
        }
    }
}
