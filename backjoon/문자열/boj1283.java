package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 문자열
 * <p>
 * 규칙에 따라 문자열을 탐색하고 map을 이용해 중복을 검증한 후,
 * 필요에 따라 변환해주면 된다.
 */
public class boj1283 {
    public static void main(String[] args) throws IOException {
        StringBuilder resultSb = new StringBuilder();
        HashMap<Character, Boolean> shortcut = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] options = new String[n];
        for (int i = 0; i < options.length; i++) {
            boolean isFinished = false;
            String[] input = bf.readLine().split(" ");
            //단어의 첫글자 탐색
            for (int j = 0; j < input.length; j++) {
                char alphabet = input[j].charAt(0);
                //해당 첫글자가 단축키로 지정이 되어있지 않으면 map에 넣고 string 치환
                if (!shortcut.containsKey(alphabet)) {
                    putAlphabet(shortcut, alphabet);
                    StringBuilder sb = new StringBuilder("[").append(alphabet).append("]").append(input[j].substring(1));
                    input[j] = sb.toString();
                    isFinished = true;
                    break;
                }
            }
            if (!isFinished) {
                //첫 글자 중 만족하는 단축키가 없으면 왼쪽부터 탐색
                outer:
                for (int j = 0; j < input.length; j++) {
                    for (int k = 1; k < input[j].length(); k++) {
                        char alphabet = input[j].charAt(k);
                        if (!shortcut.containsKey(alphabet)) {
                            putAlphabet(shortcut, alphabet);
                            StringBuilder sb = new StringBuilder(input[j].substring(0, k)).append("[").append(alphabet).append("]").append(input[j].substring(k + 1));
                            input[j] = sb.toString();
                            break outer;
                        }
                    }
                }
            }
            resultSb.append(String.join(" ", input)).append("\n");
        }
        System.out.println(resultSb);
    }

    //대소구분을 하지 않기위해 대, 소문자를 둘다 map에 넣는다.
    private static void putAlphabet(HashMap<Character, Boolean> shortcut, char alphabet) {
        if (97 <= alphabet) {
            shortcut.put(alphabet, true);
            shortcut.put((char) (alphabet - 32), true);
        }
        if (alphabet <= 90) {
            shortcut.put(alphabet, true);
            shortcut.put((char) (alphabet + 32), true);
        }
    }
}
