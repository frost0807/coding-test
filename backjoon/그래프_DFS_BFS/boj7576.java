package 그래프_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj7576 {
    static int[][] board = new int[1002][1002];
    static boolean[][] visited = new boolean[1002][1002];
    static int dist[][] = new int[1002][1002];
    static int[] dm = {0, 0, 1, -1};
    static int[] dn = {1, -1, 0, 0};

    static int minday = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = bf.readLine().split(" ");
        int m = Integer.parseInt(mn[1]);
        int n = Integer.parseInt(mn[0]);
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (board[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int row = pos[0] + dm[i];
                int col = pos[1] + dn[i];

                if (row < 0 || row >= m || col < 0 || col >= n) continue;
                if (board[row][col] == -1 || visited[row][col] == true) continue;

                visited[row][col] = true;
                dist[row][col] = dist[pos[0]][pos[1]] + 1;
                queue.add(new int[]{row, col});
                if (dist[row][col] > minday) {
                    minday = dist[row][col];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(minday);
    }
}
