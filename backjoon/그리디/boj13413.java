package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 그리디
 * <p>
 * 1번 연산을 색이 서로 다른 돌 2개를 뒤집는걸로 생각하면
 * 초기상태에서 목표상태로 갈 때,
 * 검은돌이 되어야 하는 흰돌의 갯수와 흰돌이 되어야 하는 검은돌의 갯수를 세고
 * 두 수 중 작은 수만큼 두 색의 돌을 뒤집고, 두 수의 차 만큼 한가지 색의 돌을 뒤집으면 되므로
 * 결과적으로 yyyyy
 */
public class boj13413 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            String initialState = bf.readLine();
            String goalState = bf.readLine();
            int flipCountWToB = 0;
            int flipCountBToW = 0;

            for (int j = 0; j < n; j++) {
                if (initialState.charAt(j) == 'W' && goalState.charAt(j) == 'B') {
                    flipCountWToB++;
                } else if (initialState.charAt(j) == 'B' && goalState.charAt(j) == 'W') {
                    flipCountBToW++;
                }
            }

            sb.append(Math.max(flipCountWToB, flipCountBToW)).append("\n");
        }

        System.out.println(sb);
    }
}
