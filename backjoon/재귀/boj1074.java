package 재귀;

import java.util.Scanner;

/**
 * 배열을 십자로 4등분 한 후 각 사분면에서 다시 연산하는 방식으로 해결할 수 있다.
 * */
public class boj1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int result = 0;

        for (; N > 0; N--) {
            //4사분면
            if ((r >= Math.pow(2, N - 1)) && (c >= Math.pow(2, N - 1))) {
                result += Math.pow(2, N * 2) * (0.75);
                r -= Math.pow(2, N - 1);
                c -= Math.pow(2, N - 1);
                //3사분면
            } else if ((r >= Math.pow(2, N - 1)) && (c < Math.pow(2, N - 1))) {
                result += Math.pow(2, N * 2) * (0.5);
                r -= Math.pow(2, N - 1);
                //1사분면
            } else if ((r < Math.pow(2, N - 1)) && (c >= Math.pow(2, N - 1))) {
                result += Math.pow(2, N * 2) * (0.25);
                c -= Math.pow(2, N - 1);
            }
        }

        System.out.println(result);
    }
}
