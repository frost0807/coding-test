package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Stack을 구현하는 문제, 배열을 사용하면 좀 더 최적화를 할 수 있을 것 같다.
 * */
public class boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String order = bf.readLine();
            switch (order) {
                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.remove(stack.size() - 1));
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.get(stack.size() - 1));
                    break;
                default:
                    stack.add(Integer.parseInt(order.split(" ")[1]));
                    break;
            }
        }
    }
}
