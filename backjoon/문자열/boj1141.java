package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 문자열
 * <p>
 * 문자열 길이를 기준으로 오름차순 정렬 후
 * for-loop 내에서 각 원소별로 해당 원소보다 보다 크거나 같은 문자열에 대해 접두어 검사
 */
public class boj1141 {
    public static void main(String[] args) throws IOException {
        int maxSize = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = bf.readLine();
        }
        Arrays.sort(words, new LengthComparator());
        outerloop:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].startsWith(words[i])) {
                    continue outerloop;
                }
            }
            maxSize++;
        }
        System.out.println(maxSize);
    }

    private static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}