package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * HashMap
 * <p>
 * 포켓몬 이름-번호 를 Key-Value로 하는 HashMap과
 * 포켓몬 번호-이름을 Key-Value로 하는 HashMap을 구현해서 해결
 */
public class boj1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        HashMap<String, Integer> pokemonNameMap = new HashMap<>();
        HashMap<Integer, String> pokemonNumberMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String pokemonName = bf.readLine();
            pokemonNameMap.put(pokemonName, i + 1);
            pokemonNumberMap.put(i + 1, pokemonName);
        }
        for (int i = 0; i < m; i++) {
            String str = bf.readLine();
            Integer pokemonNumber = pokemonNameMap.get(str);
            if (pokemonNumber != null) {
                sb.append(pokemonNumber).append("\n");
                continue;
            }
            sb.append(pokemonNumberMap.get(Integer.parseInt(str))).append("\n");
        }

        System.out.println(sb);
    }
}
