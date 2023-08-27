package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 체스판에 퀸을 놓는 백트래킹 문제
 * 퀸을 놓았을 때, 사용 불가능해진 체스칸을 어떻게 구현할지가 포인트
 * */
public class boj9663 {
    //board[i]는 체스판의 i+1번째 행에 퀸이 놓인 열의 index
    private static int[] board;

    //isUsedColumn[i]는 체스판의 i번째 열이 사용가능한지를 저장하는 배열
    private static boolean[] isUsedColumn;
    //isUsedDiagonalPos[i]는 체스판의 기울기가 1인 i번째 대각선 줄이 사용 가능한지를 저장하는 배열
    private static boolean[] isUsedDiagonalPos;
    //isUsedDiagonalNeg[i]는 체스판의 기울기가 -1인 i번째 대각선 줄이 사용 가능한지를 저장하는 배열
    private static boolean[] isUsedDiagonalNeg;
    private static int n;
    //조건을 만족하는 경우의 수
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        result = 0;
        board = new int[n];
        isUsedColumn = new boolean[n];
        isUsedDiagonalPos = new boolean[2 * n - 1];
        isUsedDiagonalNeg = new boolean[2 * n - 1];

        backTrack(0);

        System.out.println(result);
    }

    static void backTrack(int indexToBeFilled) {
        if (indexToBeFilled == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isUsedColumn[i]
                    && !isUsedDiagonalPos[indexToBeFilled + i]
                    && !isUsedDiagonalNeg[indexToBeFilled - i + n - 1]) {
                board[indexToBeFilled] = i;

                isUsedColumn[i] = true;
                isUsedDiagonalPos[indexToBeFilled + i] = true;
                isUsedDiagonalNeg[indexToBeFilled - i + n - 1] = true;

                backTrack(indexToBeFilled + 1);

                isUsedColumn[i] = false;
                isUsedDiagonalPos[indexToBeFilled + i] = false;
                isUsedDiagonalNeg[indexToBeFilled - i + n - 1] = false;
            }
        }
    }
}
