package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 자료구조 - Deque
 * <p>
 * LinkedList를 이용해 매 숫자를 꺼낼 때 마다 어떤 방향이 최소 횟수인지 알아 낸 후 계산
 */
public class boj1021 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<>();
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        input = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }
        for (int i = 0; i < m; i++) {
            int index = deque.indexOf(Integer.parseInt(input[i])) + 1;
            if (index - 1 <= deque.size() - index + 1) {
                result += index - 1;
                for (int j = 0; j < index - 1; j++) {
                    deque.add(deque.poll());
                }
                deque.poll();
            } else if (index - 1 > deque.size() - index + 1) {
                result += deque.size() - index + 1;
                for (int j = 0; j < deque.size() - index + 1; j++) {
                    deque.push(deque.pollLast());
                }
                deque.poll();
            }
        }
        System.out.println(result);
    }
}
