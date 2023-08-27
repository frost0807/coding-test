package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Stack 자료구조 활용하는 문제
 * 입력값이 Stack에 있으면 pop 반복해서 꺼내고,
 * Stack에 없으면 입력될 수열 탐색해서 가능/불가능 판별 후 가능하면 해당 input 나올 때 까지 push 후 pop
 * */
public class boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int numberToBePushed = 1;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(bf.readLine());
            if (stack.contains(input)) {
                while (stack.pop() != input) {
                    sb.append("-\n");
                }
                sb.append("-\n");
                continue;
            }

            if (input >= numberToBePushed) {
                while (input >= numberToBePushed) {
                    stack.push(numberToBePushed++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
                continue;
            }
            sb = new StringBuilder();
            sb.append("NO");
            break;
        }
        System.out.println(sb);
    }
}
