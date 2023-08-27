package 그래프_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1926 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board;
    static boolean[][] visited;
    static int[] dm = {0, 0, 1, -1};
    static int[] dn = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        String[] nm = bf.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        board = new int[n][m];
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        int maxPicSize = 0;
        int curPicSize;
        int picCount = 0;

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {
                if (visited[k][l] == true || board[k][l] == 0) continue;

                visited[k][l] = true;
                queue.add(new int[]{k, l});
                picCount++;
                curPicSize = 0;

                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();

                    curPicSize++;
                    for (int i = 0; i < 4; i++) {
                        int row = pos[0] + dm[i];
                        int col = pos[1] + dn[i];

                        if (row < 0 || row >= n || col < 0 || col >= m) continue;
                        if (visited[row][col] == true || board[row][col] == 0) continue;

                        visited[row][col] = true;
                        queue.add(new int[]{row, col});
                    }
                }

                if (curPicSize > maxPicSize) maxPicSize = curPicSize;
            }
        }

        System.out.println(picCount);
        System.out.println(maxPicSize);
    }
}
