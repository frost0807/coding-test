package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열
 * <p>
 * contains메소드로 해당 단어가 존재하는지 판별 후
 * replaceFirst 메소드로 해당 단어를 단어와 전혀 상관없는 문자로 바꾼 후, 숫자를 1 증가시키면 된다.
 */
public class boj1543 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String document = bf.readLine();
        String word = bf.readLine();

        while (document.contains(word)) {
            result++;
            document = document.replaceFirst(word, "*");
        }

        System.out.println(result);
    }
}
