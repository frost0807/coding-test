package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 좌표압축&이진탐색
 * <p>
 * 주어진 수들을 정렬하고 중복을 제거한 List의 index가 좌표이고 value가 원소라고 생각하면 된다.
 * List에서 처음에 주어진 숫자의 index를 찾아야 하는데 full-scan을 하면 너무 오래 걸리므로 이진탐색으로 찾아 주도록 하자
 */
public class boj18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] input = bf.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numbers);
        List<Integer> distinctNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0 || numbers[i] != numbers[i - 1]) {
                distinctNumbers.add(numbers[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(findIndexOfNumber(distinctNumbers, Integer.parseInt(s))).append(" ");
        }
        System.out.println(sb);
    }

    private static int findIndexOfNumber(List<Integer> distinctNumbers, int number) {
        int left = 0;
        int right = distinctNumbers.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (distinctNumbers.get(mid) > number) {
                right = mid - 1;
                continue;
            }
            if (distinctNumbers.get(mid) < number) {
                left = mid + 1;
                continue;
            }
            if (distinctNumbers.get(mid) == number) {
                break;
            }
        }
        return mid;
    }
}
