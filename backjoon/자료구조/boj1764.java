package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 자료구조
 * <p>
 * HashMap으로 키 존재여부 확인 후, Sort 이용해서 사전순으로 정렬
 */
public class boj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        HashMap<String, Boolean> nameMap = new HashMap<>();
        List<String> resultNames = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            nameMap.put(bf.readLine(), true);
        }
        for (int i = 0; i < m; i++) {
            String name = bf.readLine();
            if (nameMap.containsKey(name)) {
                resultNames.add(name);
            }
        }
        Collections.sort(resultNames);
        for (String resultName : resultNames) {
            sb.append(resultName).append("\n");
        }
        System.out.println(resultNames.size());
        System.out.println(sb);
    }
}
