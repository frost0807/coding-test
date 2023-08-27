package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백트래킹 문제
 * 부분수열의 크기가 0보다 크다는 조건이 있으므로 s=0일때 결과값에 부분수열의 원소가 없는 경우 1가지를 빼주면 된다.
 */
public class boj1182 {
    static int[] numbers;
    static boolean[] isUsed;
    static int n;
    static int s;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        numbers = new int[n];
        isUsed = new boolean[n];
        String[] inputNumbers = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        backTrack(0);
        if (s == 0) result--;
        System.out.println(result);
    }

    private static void backTrack(int index) {
        if (index == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (isUsed[i] ? numbers[i] : 0);
            }
            if (sum == s) result++;
            return;
        }

        isUsed[index] = false;
        backTrack(index + 1);
        isUsed[index] = true;
        backTrack(index + 1);
    }
}
