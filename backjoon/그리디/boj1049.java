package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 그리디
 * <p>
 * 여러 브랜드의 가격들 중 6개 세트의 최소값과 낱개의 최소값을 구한 후,
 * 6개 세트의 가격보다 낱개를 6개 사는 가격이 더 싸다면 모두 낱개로 사고
 * 그게 아니라면 6개 세트로 살수 있는 만큼한 세트로 사고,
 * 나머지의 갯수를 낱개로 사는것과 세트로 사는것의 가격을 비교해서 구매를 결정하면 된다.
 */
public class boj1049 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int cheapestSet = 1000;
        int cheapestOne = 1000;

        for (int i = 0; i < m; i++) {
            input = bf.readLine().split(" ");
            cheapestSet = Math.min(cheapestSet, Integer.parseInt(input[0]));
            cheapestOne = Math.min(cheapestOne, Integer.parseInt(input[1]));
        }
        if (cheapestOne * 6 <= cheapestSet) {
            result = n * cheapestOne;
        } else {
            result += (n / 6) * cheapestSet;
            if ((n % 6) * cheapestOne > cheapestSet) {
                result += cheapestSet;
            } else {
                result += (n % 6) * cheapestOne;
            }
        }
        System.out.println(result);
    }
}
