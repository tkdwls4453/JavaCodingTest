package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 키 순서
 *
 */
public class BOJ2485 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int[] input = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> graphRev = new HashMap<>();
        int n = input[0], m = input[1];

        for (int i = 0; i < m; i++) {
            int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            graph.putIfAbsent(info[0], new ArrayList<>());
            graph.get(info[0]).add(info[1]);

            graphRev.putIfAbsent(info[1], new ArrayList<>());
            graphRev.get(info[1]).add(info[0]);
        }


        for (int i = 1; i <= n; i++) {
            if (canCalculateOrder(graph, graphRev, i, n)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean canCalculateOrder(Map<Integer, List<Integer>> graph, Map<Integer, List<Integer>> graphRev, int student, int totalStudentCnt) {
        // 우선 현재 위치에서 도달할 수 있는 노드를 전부 뺀다. (bfs)
        Queue<Integer> queue = new LinkedList<>();
        boolean[] reachable = new boolean[totalStudentCnt+1];

        bfs(reachable, graph, student);
        bfs(reachable, graphRev, student);

        for (int i = 1; i < reachable.length; i++) {
            if(!reachable[i]) return false;
        }

        return true;
    }

    public static void bfs(boolean[] reachable, Map<Integer, List<Integer>> graph, int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        reachable[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if(!graph.containsKey(cur)) continue;

            for(int next : graph.get(cur)){
                if (!reachable[next]) {
                    reachable[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

}
