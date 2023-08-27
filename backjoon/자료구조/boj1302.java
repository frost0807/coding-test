package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 자료구조
 * <p>
 * TreeMap의 특성을 이용하여 책 제목별로 횟수를 저장하고
 * 가장 많은 횟수를 for-loop로 탐색한 후 maxValue에 저장한다.
 * 이미 정렬되어 있는 TreeMap의 for-loop 에서 maxValue를 가지는 key값 출력
 */
public class boj1302 {
    public static void main(String[] args) throws IOException {
        int maxValue = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Map<String, Integer> book = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            if (book.containsKey(input)) {
                book.replace(input, book.get(input) + 1);
            } else {
                book.put(input, 1);
            }
        }
        for (Integer value : book.values()) {
            maxValue = Math.max(maxValue, value);
        }
        for (Map.Entry<String, Integer> entry : book.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
