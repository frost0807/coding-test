import java.util.Scanner;

public class boj11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int multiplier = 1;
        int divider = 1;

        for (int i = 0; i < K; i++) {
            multiplier *= N - i;
            divider *= K - i;
        }

        System.out.println(multiplier / divider);
    }
}
