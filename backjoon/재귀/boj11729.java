package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 시간제한이 타이트하기 때문에 BufferedReader와 StringBuilder를 사용해 시간을 단축해야 해결 가능하다.
 *
 * 문제 해결은 재귀를 이용하면 되는데, 하노이탑의 특성을 이용하면 된다.
 * */
public class boj11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        sb.append((1 << N) - 1).append("\n");
        move(1, 3, N);
        System.out.println(sb);
    }

    static void move(int from, int to, int plateCount) {
        if (plateCount == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }
        move(from, 6 - from - to, plateCount - 1);
        sb.append(from + " " + to + "\n");
        move(6 - from - to, to, plateCount - 1);
    }
}
