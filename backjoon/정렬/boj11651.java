package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2가지 기준에 의해서 정렬을 할 수 있는지를 묻는 문제
 * */
public class boj11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        List<PosXY> xy = new ArrayList<>(N);
        for (; N > 0; N--) {
            String[] number = bf.readLine().split(" ");
            xy.add(new PosXY(Integer.parseInt(number[0]), Integer.parseInt(number[1])));
        }
        Collections.sort(xy);

        for (PosXY posXY : xy) {
            System.out.println(posXY.x + " " + posXY.y);
        }
    }
}

class PosXY implements Comparable<PosXY> {
    int x;
    int y;

    @Override
    public int compareTo(PosXY o) {
        if (this.y != o.y) {
            return (this.y - o.y);
        } else {
            return (this.x - o.x);
        }
    }

    public PosXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
