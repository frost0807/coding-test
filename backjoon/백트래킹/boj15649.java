package 백트래킹;

import java.util.Scanner;

/**
 * 재귀와 백트래킹을 이용한 문제
 * */
public class boj15649 {
    //재귀를 도는동안 상태 관리를 해야하므로 전역변수로 선언
    static int n;
    static int m;
    static int[] result;
    static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];
        isUsed = new boolean[n + 1];

        addNumber(0);
    }

    static void addNumber(int indexToBeFilled) {
        //result가 다 채워졌으면 결과를 출력하고 return
        if (indexToBeFilled == m) {
            for (Integer i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        //result다 다 채워지지 않았으면 아직 사용하지 않은 숫자들은 낮은 수부터 차례차례 대입
        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                result[indexToBeFilled] = i;
                isUsed[i] = true;
                addNumber(indexToBeFilled + 1);
                isUsed[i] = false;
            }
        }
    }
}
