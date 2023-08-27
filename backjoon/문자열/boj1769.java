package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1769 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();

        multiple(X);
    }

    public static void multiple(String x) {
        int sum = 0;

        if(x.length() == 1) {
            System.out.println(cnt);
            if(Integer.parseInt(x) % 3 == 0) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            return;
        }else {
            for(int i=0; i<x.length(); i++) {
                sum = sum + Integer.parseInt(String.valueOf(x.charAt(i)));
            }
            cnt++;
            multiple(Integer.toString(sum));
        }
    }
}