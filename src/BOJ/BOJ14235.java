package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 크리스마스 선물
 * 입력 크기: 5*10^3 -> n^2 까지 풀림.
 * 아이를 만나면 가치가 가장 큰 선물을 주기 때문에, max 힙을 사용할 수 있다.
 */
public class BOJ14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] input =  br.readLine().split(" ");

            // 아이를 만난 경우
            if (input.length == 1 && input[0].equals("0")) {
                if(pq.isEmpty()) System.out.println(-1);
                else System.out.println(pq.poll());
            }
            // 선물 충전
            else{
                for(int j=0; j<input.length; j++){
                    if(j != 0){
                        pq.offer(Integer.parseInt(input[j]));
                    }
                }
            }
        }
    }
}
