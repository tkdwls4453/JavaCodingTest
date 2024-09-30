package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 바이러스
 *
 * 요약하자면 시작 노드에서 부터 도달할 수 있는 모든 노드의 개수를 구하는 문제이다.
 * BFS, DFS 로 문제를 해결할 수 있다. 여기서는 BFS 로 문제를 해결했다.
 *
 * 최대 N 은 100 으로 문제없이 풀릴 것으로 예상한다.
 */
public class BOJ2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerCnt = Integer.parseInt(br.readLine());
        int linkCnt = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[computerCnt + 1];
        // graph 구성 양방향이기 때문에 양쪽으로 추가
        for (int i = 0; i < linkCnt; i++) {
            int[] link = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.putIfAbsent(link[0], new ArrayList<>());
            graph.get(link[0]).add(link[1]);

            graph.putIfAbsent(link[1], new ArrayList<>());
            graph.get(link[1]).add(link[0]);
        }

        queue.offer(1);
        visited[1] = true;

        int result = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();


            if(!graph.containsKey(cur)) continue;

            for(int next : graph.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
