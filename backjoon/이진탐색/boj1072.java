package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진탐색
 * <p>
 * 현재 승률이 99이상이면 승률을 올릴 수 없으므로 -1 출력하고
 * 그 외의 경우는 추가적인 게임횟수를 계산했을 때, 승률이 1 증가하는 mid값에 대한 이진탐색을 수행ㄴ
 */
public class boj1072 {
    public static void main(String[] args) throws IOException {
        int result = -1;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        long winRateToBeSatisfied = 100L * y / x + 1;
        if (winRateToBeSatisfied <= 99) {
            int low = 1;
            int high = 1000000000;
            int mid = -1;
            //mid가 winRateToBeSatisfied를 만족하는 가장 작은 값을 가리키면 됨
            while (low < high) {
                mid = (low + high) / 2;
                long currentWinRate = 100L * (y + mid) / (x + mid);
                if (currentWinRate >= winRateToBeSatisfied) {
                    high = mid;
                    continue;
                }
                low = mid + 1;
            }
            result = low;
        }
        System.out.println(result);
    }
}
