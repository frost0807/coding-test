package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 이진탐색
 * <p>
 * 파일의 크기들을 오름차순으로 정렬한 후,
 * for-loop로 각 파일의 크기를 0.9로 나눈 값보다 작거나 같은 파일의 최대 index를 구한다음,
 * 기준 파일의 index와의 차로 순서쌍 갯수를 계산할 수 있다.
 * 순서쌍의 최대 갯수가 int형의 범위를 넘어가니 long 타입을 사용해야 하는걸 주의하자.
 */
public class boj2428 {
    public static void main(String[] args) throws IOException {
        long result = 0;
        int left;
        int right;
        int mid;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] files = new int[n];
        String[] input = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            files[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(files);
        for (int i = 0; i < n; i++) {
            int size = files[i] * 10 / 9;
            left = i;
            right = n - 1;

            while (left < right) {
                mid = (left + right + 1) / 2;
                if (files[mid] <= size) left = mid;
                else right = mid - 1;

            }
            result += left - i;
        }

        System.out.println(result);
    }
}
