package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 정렬
 * <p>
 * Comparable 인터페이스 구현 후 문제의 조건에 해당하는 대소비교 구현
 */
public class boj1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<SerialNumber> serialNumbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            serialNumbers.add(new SerialNumber(bf.readLine()));
        }
        Collections.sort(serialNumbers);

        StringBuilder sb = new StringBuilder();
        for (SerialNumber serialNumber : serialNumbers) {
            sb.append(serialNumber.text).append("\n");
        }
        System.out.println(sb);
    }

}

class SerialNumber implements Comparable<SerialNumber> {
    String text;

    public SerialNumber(String text) {
        this.text = text;
    }

    @Override
    public int compareTo(SerialNumber o) {
        if (this.text.length() != o.text.length()) {
            return (this.text.length() - o.text.length());
        }
        int sumOfFirst = 0;
        int sumOfSecond = 0;

        for (int i = 0; i < this.text.length(); i++) {
            char letterOfFirst = this.text.charAt(i);
            char letterOfSecond = o.text.charAt(i);
            if (letterOfFirst >= '1' && letterOfFirst <= '9') {
                sumOfFirst += letterOfFirst - 48;
            }
            if (letterOfSecond >= '1' && letterOfSecond <= '9') {
                sumOfSecond += letterOfSecond - 48;
            }
        }

        if (sumOfFirst != sumOfSecond) {
            return sumOfFirst - sumOfSecond;
        }

        for (int i = 0; i < this.text.length(); i++) {
            char letterOfFirst = this.text.charAt(i);
            char letterOfSecond = o.text.charAt(i);
            if (letterOfFirst != letterOfSecond) {
                return letterOfFirst - letterOfSecond;
            }
        }

        return 0;
    }
}
