package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 문자열
 * <p>
 * HashMap을 이용해 단어의 index를 탐색하면서,
 * 전과 같은 알파벳이 아니고 해당 알파벳이 HashMap에 존재하면 그룹 단어가 아닌걸로 판단
 */
public class boj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int result = n;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Boolean> alphabetMap = new HashMap<>();
            String input = bf.readLine();
            for (int j = 0; j < input.length(); j++) {
                char alphabet = input.charAt(j);
                if (alphabetMap.containsKey(alphabet) && (input.charAt(j - 1) != input.charAt(j))) {
                    result--;
                    break;
                }
                alphabetMap.put(alphabet, true);
            }
        }
        System.out.println(result);
    }
}
