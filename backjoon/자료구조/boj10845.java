package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class boj10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String order = bf.readLine();
            switch (order) {
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.remove(0));
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.get(0));
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : queue.get(queue.size() - 1));
                    break;
                default:
                    queue.add(Integer.parseInt(order.split(" ")[1]));
                    break;
            }
        }
    }
}
