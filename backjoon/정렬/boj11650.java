package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 좌표를 x값 기준으로 정렬하고 x값이 같다면 y값 기준으로 정렬
 * */
public class boj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        List<Pos> xy = new ArrayList<>(N);
        for (; N > 0; N--) {
            String[] number = bf.readLine().split(" ");
            xy.add(new Pos(Integer.parseInt(number[0]), Integer.parseInt(number[1])));
        }
        Collections.sort(xy);

        for (Pos pos : xy) {
            System.out.println(pos.x + " " + pos.y);
        }
    }
}

class Pos implements Comparable<Pos> {
    int x;
    int y;

    @Override
    public int compareTo(Pos o) {
        if (this.x != o.x) {
            return (this.x - o.x);
        } else {
            return (this.y - o.y);
        }
    }

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
