package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 문자열
 * <p>
 * 모든 경우 다 돌려서 List 정렬 후 출력
 */
public class boj1251 {
    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        //왼쪽 단어 for-loop
        for (int i = 1; i < input.length() - 1; i++) {
            //가운데 단어 for-loop
            for (int j = i + 1; j < input.length(); j++) {
                StringBuilder left = new StringBuilder(input.substring(0, i)).reverse();
                StringBuilder middle = new StringBuilder(input.substring(i, j)).reverse();
                StringBuilder right = new StringBuilder(input.substring(j)).reverse();
                words.add(left.append(middle).append(right).toString());
            }
        }
        Collections.sort(words);
        System.out.println(words.get(0));
    }
}