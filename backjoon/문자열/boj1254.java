package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열(팰린드롬)
 * <p>
 * 입력값이 팰린드롬인 경우부터 낮은 index의 알파벳들을 줄여가면서
 * 언제가 팰린드롬이 되는지를 확인하고 추가해야 될 알파벳의 개수를 구하면 된다.
 */
public class boj1254 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (isPalindrome(input.substring(i))) {
                result = input.length() + i;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
