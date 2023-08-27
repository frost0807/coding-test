import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int dasom = Integer.parseInt(bf.readLine());
        int[] arr = new int[N - 1];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(bf.readLine());

        int min = 0;
        if (N == 1) {
            System.out.println("0");
            return;
        }

        while (true) {
            Arrays.sort(arr);
            boolean flag = true;
            int last = arr.length - 1;
            if (dasom <= arr[arr.length - 1]) {
                dasom++;
                arr[last]--;
                min++;
                flag = false;
            }
            if (flag) {
                break;
            }
        }
        System.out.println(min);
        bf.close();
    }

}