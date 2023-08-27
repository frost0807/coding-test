package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 문자열
 */
public class boj2941 {
    public static void main(String[] args) throws IOException {
        /**
         * c로 시작 : c=, c-
         * d로 시작 : dz=, d-
         * l로 시작 : lj
         * n으로 시작 : nj
         * s로 시작 : s=
         * z로 시작 : z=
         *
         * 크로아티아 알파벳은 2, 3 글자
         * 3글자는 dz=이므로 앞 2글자가 dz이면 자동으로 dz=
         * */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        List<Character> crAlphabetPrefixes = List.of('c', 'd', 'l', 'n', 's', 'z');
        List<String> twoSpellCrAlphabets = List.of("c=", "c-", "d-", "lj", "nj", "s=", "z=");
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (crAlphabetPrefixes.contains(s.charAt(i)) && (i + 2) <= s.length()) { //크로아티아 알파벳 접두사가 붙고 남은 문자열이 2자 이상이면
                if (twoSpellCrAlphabets.contains(s.substring(i, i + 2))) { //문자열 2자가 크로아티아 알파벳이면
                    i += 2;
                    count++;
                    continue;
                } else if ((i + 3) <= s.length() && s.substring(i, i + 3).equals("dz=")) { //남은 문자열이 3자 이상이고 3자가 크로아티아 알파벳이면
                    i += 3;
                    count++;
                    continue;
                }
            }

            i++;
            count++;
        }
        System.out.println(count);
    }
}