package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 최소 힙
 * 입력 크기 : 10^5 -> O(nlog(n)) 이하의 알고리즘 필요
 * -> 매번 작은 값을 꺼내와야 하기 때문에 최소 힙을 사용하 수 있다.
 * -> nlog(n)
 */
public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());

            if(value != 0) pq.offer(value);
            else if (pq.isEmpty()) System.out.println(0);
            else System.out.println(pq.poll());
        }
    }
}
