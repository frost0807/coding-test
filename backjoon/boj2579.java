import java.util.Scanner;

public class boj2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stairN = sc.nextInt();
        //d[x][y]은 x번째 계단에 도달할 때 y개의 계단을 뛰어서 도달했을 때 점수
        int[][] d = new int[stairN + 2][3];
        int[] score = new int[stairN + 2];
        for (int i = 1; i <= stairN; i++) {
            score[i] = sc.nextInt();
        }
        d[1][1] = score[1];
        d[1][2] = score[1];
        d[2][1] = score[2] + score[1];
        d[2][2] = score[2];

        for (int i = 3; i <= stairN; i++) {
            d[i][1] = score[i] + d[i - 1][2];
            d[i][2] = score[i] + Math.max(d[i - 2][1], d[i - 2][2]);
        }
        System.out.println(Math.max(d[stairN][1], d[stairN][2]));
    }
}
