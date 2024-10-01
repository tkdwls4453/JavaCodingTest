package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 숨바꼭질
 */
public class BOJ1679 {
    public static final int MAX_SIZE = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int start = input[0], target = input[1];
        boolean[] visited = new boolean[MAX_SIZE+1];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        int result = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == target) {
                result = cur[1];
                break;
            }

            if(cur[0] -1 >= 0 && !visited[cur[0]-1]){
                visited[cur[0]-1] = true;
                queue.offer(new int[]{cur[0] - 1, cur[1] + 1});
            }

            if (cur[0] + 1 <= MAX_SIZE && !visited[cur[0] + 1]) {
                visited[cur[0] + 1] = true;
                queue.offer(new int[]{cur[0] + 1, cur[1] + 1});
            }

            if (cur[0] * 2 <= MAX_SIZE && !visited[cur[0] * 2]) {
                visited[cur[0] * 2] = true;
                queue.offer(new int[]{cur[0] * 2, cur[1] + 1});
            }
        }

        System.out.println(result);
    }

}
