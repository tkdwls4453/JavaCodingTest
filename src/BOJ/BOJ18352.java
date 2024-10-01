package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 특정 거리의 도시 찾기
 *
 * 주어진 최단 거리로 갈 수 있는 도시들을 찾는 문제이다.
 * 1. 우선 주어진 정보로 그래프를 생성한다.
 * 2. 다익스트라 알고리즘으로 현재 위치에서 각 도시별 갈 수 있는 최단 거리를 구한다.
 * 3. 최단 거리가 주어진 최단 거리와 같은 도시를 출력한다. 없다면 -1 출력한다.
 */
public class BOJ18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cityCnt = input[0], roadCnt = input[1], targetDist = input[2], startCity = input[3];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });

        int[] distance = new int[cityCnt+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while (roadCnt-- > 0) {
            int[] road = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.putIfAbsent(road[0], new ArrayList<>());
            graph.get(road[0]).add(road[1]);
        }

        distance[startCity] = 0;
        pq.offer(new int[]{startCity, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(!graph.containsKey(cur[0])) continue;

            for (int next : graph.get(cur[0])) {
                int newDist = cur[1] + 1;
                if (newDist < distance[next]) {
                    distance[next] = newDist;
                    pq.offer(new int[]{next, newDist});
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == targetDist) {
                sb.append(i).append("\n");
            }
        }

        String result = sb.length() == 0 ? "-1" : sb.toString();
        System.out.println(result);
    }
}
