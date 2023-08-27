package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 이분탐색 문제
 * 자르는 높이가 0일때를 lowest, 가장 긴 나무의 길이일때를 highest로 잡고
 * 나무길이의 총합 sum이 m이상인 경우에 대해서 m에 최대한 근접한 값을 구하면 된다.
 */
public class boj2805 {
    public static void main(String[] args) throws IOException {
        long sum;
        int result = 0;
        int lowest;
        int highest = 0;
        int mid = 0;


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        s = bf.readLine().split(" ");
        List<Integer> trees = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int tree = Integer.parseInt(s[i]);
            trees.add(tree);
            highest = Math.max(highest, tree);
        }
        lowest = 0;
        while (lowest <= highest) {
            mid = (lowest + highest) / 2;
            sum = 0;
            for (Integer tree : trees) {
                if (tree > mid) sum += tree - mid;
            }

            if (sum > m) {
                result = mid;
                lowest = mid + 1;
                continue;
            }
            if (sum < m) {
                highest = mid - 1;
                continue;
            }
            result = mid;
            break;
        }

        System.out.println(result);
    }
}
