package 자료구조;

import java.util.*;

/**
 * Queue 자료구조의 특성을 이용해 해결하는 문제
 * */
public class boj11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> queue = new LinkedList();
        List<Integer> result = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            result.add(queue.poll());
        }
        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(i == result.size() - 1 ? result.get(i) : result.get(i) + ", ");
        }
        System.out.print(">");
    }
}
