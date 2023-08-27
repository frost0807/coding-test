package 그래프_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1012 {
    static int[] dm = {0, 0, 1, -1};
    static int[] dn = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //case 수
        int T = Integer.parseInt(bf.readLine());
        //결과 배열
        int[] result = new int[T];

        for (int i = 0; i < T; i++) {
            String[] s = bf.readLine().split(" ");
            //row 수
            int N = Integer.parseInt(s[0]);
            //col 수
            int M = Integer.parseInt(s[1]);
            //배추 수
            int K = Integer.parseInt(s[2]);
            //벌레 수
            int bug = 0;
            Stack<int[]> stack = new Stack<>();
            boolean[][] visited = new boolean[M + 2][N + 2];
            int[][] board = new int[M + 2][N + 2];
            for (int j = 0; j < K; j++) {
                String[] s1 = bf.readLine().split(" ");
                board[Integer.parseInt(s1[1])][Integer.parseInt(s1[0])] = 1;
            }
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] == 1 && visited[j][k] == false) {
                        visited[j][k] = true;
                        bug++;
                        stack.add(new int[]{j, k});

                        while (!stack.isEmpty()) {
                            int[] pos = stack.pop();

                            for (int l = 0; l < 4; l++) {
                                int row = pos[0] + dm[l];
                                int col = pos[1] + dn[l];
                                if (row < 0 || row >= M || col < 0 || col >= N) continue;
                                if (visited[row][col] == true || board[row][col] != 1) continue;
                                visited[row][col] = true;
                                stack.add(new int[]{row, col});
                            }
                        }
                    }
                }
            }
            result[i] = bug;
        }
        for (int i : result) {
            System.out.println(i);
        }
    }
}
