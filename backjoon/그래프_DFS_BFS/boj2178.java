package 그래프_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj2178 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] dm = {0, 0, 1, -1};
    static int[] dn = {1, -1, 0, 0};
    static int[][] board;
    static int[][] dist;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        String[] mn = bf.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        Queue<int[]> queue = new LinkedList<>();
        board = new int[m + 2][n + 2];
        dist = new int[m + 2][n + 2];
        visited = new boolean[m + 2][n + 2];

        for (int i = 0; i < m; i++) {
            String[] mLine = bf.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(mLine[j]);
            }
        }

        visited[0][0] = true;
        dist[0][0] = 1;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = pos[0] + dm[i];
                int col = pos[1] + dn[i];

                if (row < 0 || row >= m || col < 0 || col >= n) continue;
                if (visited[row][col] == true || board[row][col] == 0) continue;

                visited[row][col] = true;
                queue.add(new int[]{row, col});
                dist[row][col] = dist[pos[0]][pos[1]] + 1;
            }
        }

        System.out.println(dist[m - 1][n - 1]);
    }
}
