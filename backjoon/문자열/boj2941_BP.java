package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열
 */

public class boj2941_BP {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine().replaceAll("c=|c-|d-|dz=|lj|nj|s=|z=", " ");
        System.out.println(input.length());
    }
}