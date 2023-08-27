package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 정렬
 * <p>
 * 알파벳 순으로 정렬하는 Comparator를 구현한 후, 문자열을 알파벳순으로 정렬해 Map을 이용해 총 그룹수 세기
 */
public class boj16499 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        HashMap<String, Boolean> wordGroup = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split("");
            Arrays.sort(input, new AlphabetComparator());
            StringBuilder sb = new StringBuilder();
            for (String s : input) {
                sb.append(s);
            }
            wordGroup.put(sb.toString(), true);
        }
        System.out.println(wordGroup.size());
    }
}

class AlphabetComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.toCharArray()[0] - o2.toCharArray()[0];
    }
}