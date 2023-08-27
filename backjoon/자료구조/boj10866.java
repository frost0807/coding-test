package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Deque 구현하는 문제
 * */
public class boj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String order = bf.readLine();
            switch (order) {
                case "pop_front":
                    System.out.println(deque.isEmpty() ? -1 : deque.remove(0));
                    break;
                case "pop_back":
                    System.out.println(deque.isEmpty() ? -1 : deque.remove(deque.size() - 1));
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(deque.isEmpty() ? -1 : deque.get(0));
                    break;
                case "back":
                    System.out.println(deque.isEmpty() ? -1 : deque.get(deque.size() - 1));
                    break;
                default:
                    if (order.split(" ")[0].equals("push_front")) {
                        deque.add(0, Integer.parseInt(order.split(" ")[1]));
                    } else if (order.split(" ")[0].equals("push_back")) {
                        deque.add(Integer.parseInt(order.split(" ")[1]));
                    }

            }
        }
    }
}
