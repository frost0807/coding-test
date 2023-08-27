package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A를 계속 곱하면서 C로 나눈 나머지를 계산하면 O(n)이므로 시간초과가 발생한다.
 * 재귀를 이용하여 제곱수를 절반으로 계속 줄여 시간복잡도를 O(logN)으로 줄이는게 핵심
 * */
public class boj1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int C = Integer.parseInt(s[2]);

        System.out.println(Pow(A, B, C));
    }

    static long Pow(long number, long square, long m) {
        if (square == 1) return number % m;
        long temp = Pow(number, square / 2, m);

        if (square % 2 == 0) {
            return (temp * temp) % m;
        } else {
            return (((temp * temp) % m) * number) % m;
        }
    }
}
