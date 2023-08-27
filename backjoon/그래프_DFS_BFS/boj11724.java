package 그래프_DFS_BFS;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj11724 {
    static int[] dm = {0, 0, 1, -1};
    static int[] dn = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        List<Integer>[] board = new LinkedList[N + 2];
        for (int i = 1; i <= N; i++) {
            board[i] = new LinkedList<>();
        }
        boolean[] visited = new boolean[N + 2];
        int element = 0;

        for (int i = 0; i < M; i++) {
            String[] s1 = bf.readLine().split(" ");
            int row = Integer.parseInt(s1[0]);
            int col = Integer.parseInt(s1[1]);
            board[row].add(col);
            board[col].add(row);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == true) continue;
            element++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int nxt : board[cur]) {
                    if (visited[nxt]) continue;
                    queue.add(nxt);
                    visited[nxt] = true;
                }
            }
        }
        System.out.println(element);
    }
}
