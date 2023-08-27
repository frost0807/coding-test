import java.util.Scanner;

public class boj10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];

        for (int i = 0; i < T; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int pre = (((N - 1) % H) + 1) * 100;
            int suf = ((N - 1) / H) + 1;
            result[i] = pre + suf;
        }
        for (int i : result) {
            System.out.println(i);
        }
    }
}
