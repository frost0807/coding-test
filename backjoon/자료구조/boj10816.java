package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * HashMap을 사용해 해결했지만 이진탐색으로도 풀이 가능
 * */
public class boj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Integer, Integer> NMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            NMap.put(key, NMap.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(NMap.getOrDefault(key, 0)).append(' ');
        }

        System.out.println(sb);
    }
}
