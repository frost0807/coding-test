package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진탐색
 * 각 블루레이의 재생시간에 대한 이진탐색을 수행하는데,
 * 1을 lowest로, 모든 강의길이의 합을 highest로 잡고
 * 강의가 블루레이에 다 들어가면 highest를 낮추고,
 * 강의가 블루레이에 다 안들어가면 lowest를 높여서 적정 지점을 찾는다.
 */
public class boj2343 {
    public static void main(String[] args) throws IOException {
        int lowest = 1;
        int highest = 0;
        int mid;
        int result = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        input = bf.readLine().split(" ");
        int[] lectures = new int[n];
        for (int i = 0; i < n; i++) {
            int playtime = Integer.parseInt(input[i]);
            lectures[i] = playtime;
            highest += playtime;
        }

        while (lowest <= highest) {
            mid = (lowest + highest) / 2;
            int index = 0;
            for (int i = 0; i < m; i++) {
                int sum = 0;
                while ((index < n) && (mid >= sum + lectures[index])) {
                    sum += lectures[index];
                    index++;
                }
            }

            if (index >= n) {
                result = mid;
                highest = mid - 1;
                continue;
            }
            if (index < n) {
                lowest = mid + 1;
                continue;
            }
        }

        System.out.println(result);
    }
}
