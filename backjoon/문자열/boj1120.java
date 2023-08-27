package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 문제
 */
public class boj1120 {
    public static void main(String[] args) throws IOException {
        int minDifference = 50;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        String a = input[0];
        String b = input[1];
        int lengthGap = b.length() - a.length();

        for (int i = 0; i <= lengthGap; i++) {
            int difference = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j + i)) {
                    difference++;
                }
            }
            minDifference = Math.min(minDifference, difference);
        }
        System.out.println(minDifference);
    }
}
