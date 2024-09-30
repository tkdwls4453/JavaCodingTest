package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 나이트의 이동
 * 나이트는 8가지 방향으로 이동하며 출발지에서 도착지까지 도착하기 위한 최단 거리를 구하기 위해서 BFS 를 사용하였다.
 */
public class BOJ7562 {
    public static final int[][] moves = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[size][size];

            int[] start = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] dest = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int result = bfs(start, dest, 0, visited);
            System.out.println(result);

        }
    }

    public static int bfs(int[] start, int[] dest, int depth, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == dest[0] && cur[1] == dest[1]){
                return cur[2];
            }
            for(int[] move : moves){
                int nextR = cur[0] + move[0];
                int nextC = cur[1] + move[1];
                int nextDepth = cur[2] + 1;
                if (nextR >= 0 && nextR < visited.length && nextC >= 0 && nextC < visited.length) {
                    if (!visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        queue.offer(new int[]{nextR, nextC, nextDepth});
                    }
                }
            }
            depth++;
        }

        return -1;
    }
}
