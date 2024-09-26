package BOJ;

import java.util.*;
import java.io.*;

/**
 * 센티와 마법의 뿅마치
 *
 * 입력 크기 : 10^5 -> O(n^2) 은 안되는구나
 * 매번 제일 키가 큰 거인의 키를 반으로 줄인다.
 *  -> 매번 정렬해야 하나?
 *      최악의 경우, t * nlog(n) -> t==n , n^2 log(n) 시간초과
 *  -> 우선순위 큐 사용하면? (최대 힙)
 *      최악의 경우, nlog(n) 번 삽입, nlog(n) 번 추출, nlog(n) 번 삽입 -> O(nlog(n)) 가능
 */
public class BOJ19638 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int centi = Integer.parseInt(input[1]);
        int t = Integer.parseInt(input[2]);

        // max 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        // 거인 키 입력받아 max 힙에 채운다.
        for (int i = 0; i < size; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;

        // 아직 시도 횟수가 남아 있고, 센티보다 키가 큰 사람이 있다면 계속 반복
        while (t > cnt && pq.peek() >= centi) {
            int cur = pq.poll();
            cur = Math.max(cur / 2, 1);
            pq.offer(cur);
            cnt++;
        }

        if(centi > pq.peek()){
            System.out.println("YES");
            System.out.println(cnt);

        }else{
            System.out.println("NO");
            System.out.println(pq.peek());
        }
    }
}
