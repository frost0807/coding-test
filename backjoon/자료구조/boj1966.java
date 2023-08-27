package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        List<Integer> result = new ArrayList<>(T);
        for (; T > 0; T--) {
            String[] s = bf.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int docIndex = Integer.parseInt(s[1]);
            //중요도 당 존재하는 문서의 갯수 1-9
            int[] priorityCount = new int[10];
            //현재 존재하는 최대 중요도
            int maxPriority = 9;
            //인쇄된 문서의 수
            int count = 0;
            //문서의 중요도가 들어있는 큐
            Queue<Integer> docQueue = new LinkedList();
            s = bf.readLine().split(" ");

            //queue에 문서들을 넣고, 중요도 별로 몇개의 문서가 존재하는지 priorityCount에 기록
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(s[i]);
                docQueue.add(priority);
                priorityCount[priority]++;
            }
            //priorityCount를 탐색해 현재 최대 중요도가 몇인지 기록
            for (int i = 9; i > 0; i--) {
                if (priorityCount[i] != 0) {
                    maxPriority = i;
                    break;
                }
            }
            //원하는 문서가 인쇄되면 중단
            while (true) {
                //queue의 맨 앞의 문서가 존재하는 최대 중요도이면 인쇄하고 priorityCount배열의 해당 중요도 값 1 감소
                if (docQueue.peek() == maxPriority) {
                    count++;
                    //출력된 문서가 원하는 문서라면 순번을 result에 기록하고 반복 중단
                    if (docIndex == 0) {
                        result.add(count);
                        break;
                    }
                    //출력된 문서가 원하는 문서가 아니라면 문서만 인쇄하고 priorityCount과 docIndex를 1 감소
                    docQueue.poll();
                    priorityCount[maxPriority]--;
                    docIndex--;
                    //감소된 중요도가 이제 존재하지 않으면 다음 최대 중요도를 탐색
                    if (priorityCount[maxPriority] == 0) {
                        for (int i = maxPriority - 1; i > 0; i--) {
                            if (priorityCount[i] != 0) {
                                maxPriority = i;
                                break;
                            }
                        }
                    }
                } else {
                    //queue의 맨 앞의 문서가 존재하는 최대 중요도가 아니라면 queue의 뒤로 보내기
                    docQueue.add(docQueue.poll());
                    //원하는 문서가 맨 앞이면 docIndex를 맨 뒤로 세팅하고 아니면 1감소
                    if (docIndex == 0) {
                        docIndex = docQueue.size() - 1;
                    } else {
                        docIndex--;
                    }
                }
            }
        }

        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
