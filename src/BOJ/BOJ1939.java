package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 중량제한
 */
public class BOJ1939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int n = input[0], m = input[1];
        long[] weight = new long[n+1];

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Long.compare(o2[1], o1[1]);
        });

        Map<Long, List<long[]>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            long[] info = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

            graph.putIfAbsent(info[0], new ArrayList<>());
            graph.get(info[0]).add(new long[]{info[1], info[2]});

            graph.putIfAbsent(info[1], new ArrayList<>());
            graph.get(info[1]).add(new long[]{info[0], info[2]});
        }

        int[] targetInfo = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int start = targetInfo[0], dest = targetInfo[1];

        pq.offer(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            if(cur[0] == dest) break;

            for (long[] next : graph.get(cur[0])) {
                if (cur[0] == start) {
                    weight[(int) next[0]] = next[1];
                    pq.offer(new long[]{next[0], next[1]});
                }else{
                    long cost = Math.min(weight[(int) cur[0]], next[1]);

                    if (weight[(int) next[0]] < cost) {
                        weight[(int) next[0]] = cost;
                        pq.offer(new long[]{next[0], cost});
                    }
                }
            }
        }

        System.out.println(weight[dest]);

    }
}
