package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 문자열
 * <p>
 * 주어진 알파벳에 따라 경우의 수를 나눠서 문자열을 변형하여 팰린드롬을 만들면 된다.
 */
public class boj1213 {
    public static void main(String[] args) throws IOException {
        int oddCount = 0;
        char oddAlphabet = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] input = bf.readLine().toCharArray();
        HashMap<Character, Integer> alphabetMap = new HashMap<>();

        //알파벳별로 갯수 초기화
        for (int i = 65; i <= 90; i++) {
            alphabetMap.put((char) i, 0);
        }
        //입력값만큼 알파벳 갯수 변경
        for (char alphabet : input) {
            alphabetMap.put(alphabet, alphabetMap.get(alphabet) + 1);
        }
        //갯수가 홀수인 알파벳이 몇개인지를 검사
        for (int i = 65; i <= 90; i++) {
            if (alphabetMap.get((char) i) % 2 != 0) {
                oddCount++;
                oddAlphabet = (char) i;
                //홀수인 알파벳이 2개 이상이면 팰린드롬으로 변형 불가
                if (oddCount >= 2) {
                    sb.append("I'm Sorry Hansoo");
                    break;
                }
            }
        }
        //홀수인 알파벳이 존재하지 않으면 갯수를 절반으로 나눈 후, 역순으로 앞뒤에 붙여나가기
        if (oddCount == 0) {
            for (int i = 90; i >= 65; i--) {
                int count = alphabetMap.get((char) i) / 2;
                for (int j = 0; j < count; j++) {
                    sb.insert(0, (char) i);
                    sb.append((char) i);
                }
            }
        }
        //홀수인 알파벳이 존재하면 그 알파벳 1개를 중간에 두고 나머지는 갯수의 절반만큼 역순으로 앞 뒤로 붙이기
        if (oddCount == 1) {
            sb.append(oddAlphabet);
            alphabetMap.put(oddAlphabet, alphabetMap.get(oddAlphabet) - 1);
            for (int i = 90; i >= 65; i--) {
                int count = alphabetMap.get((char) i) / 2;
                for (int j = 0; j < count; j++) {
                    sb.insert(0, (char) i);
                    sb.append((char) i);
                }
            }
        }

        System.out.println(sb);
    }
}
