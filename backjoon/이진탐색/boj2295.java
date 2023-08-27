package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이진탐색
 * <p>
 * 단순히 4중 for-loop로 해결하려 하면 시간이 부족한 관계로 시간복잡도를 줄이는 것이 핵심!
 * 두 수를 더한 값을 집합으로 만들고
 * (세 수의 합 중 가장 큰 값의 후보 - 어떤 값) = 두수를 더한 값의 집합
 * 에 대한 이진탐색을 수행하면 된다
 */
public class boj2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] u = new int[n];
        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(u);
        LinkedHashSet<Integer> twoSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                twoSet.add(u[i] + u[j]);
            }
        }
        ArrayList<Integer> two = new ArrayList<>(twoSet);
        //이진탐색을 위해 정렬
        Collections.sort(two);
        outer:
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (search(two, u[i] - u[j])) {
                    System.out.println(u[i]);
                    break outer;
                }
            }
        }
    }

    private static boolean search(List<Integer> two, int number) {
        int left = 0;
        int right = two.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (two.get(mid) < number) {
                left = mid + 1;
                continue;
            }
            if (two.get(mid) > number) {
                right = mid - 1;
                continue;
            }
            if (two.get(mid) == number) {
                break;
            }
        }
        return two.get(mid) == number;
    }
}
