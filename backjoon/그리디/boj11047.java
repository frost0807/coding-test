package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 그리디
 * <p>
 * 기초적인 그리디 문제
 */
public class boj11047 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] coins = new int[n];
        for (int i = coins.length - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(bf.readLine());
        }
        for (int coin : coins) {
            if (k == 0) {
                break;
            }
            result += k / coin;
            k %= coin;
        }
        System.out.println(result);
    }
}
