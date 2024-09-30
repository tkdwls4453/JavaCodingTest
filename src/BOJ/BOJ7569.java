package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 토마토
 *
 * 익은 토마토는 주변에 있는 토마토를 익한다. (대각선 방향을 제외한 6방향)
 * 모든 토마토를 익히는데 걸리는 일수를 구하는 문제이다.
 * 모든 토마토가 익었는 지 확인하기 위해 매번 체크하는 것을 시간 복잡도를 많이 잡아먹기 때문에,
 * 처음에 익지 않은 토마토 개수를 구하고 토마토가 익을 때마다 줄이는 쪽으로 체크한다.
 * 최소일 수를 구하기 때문에 BFS 를 사용한다.
 */
public class BOJ7569 {
    static final int[][] DIRECTION = new int[][]{{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = input[1], col = input[0], height = input[2];

        int[][][] warehouse = new int[height][row][col];
        int unripeCnt = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<height; i++){
            for (int j = 0; j < row; j++) {
                int[] info = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                for (int k = 0; k < col; k++) {
                    warehouse[i][j][k] = info[k];
                    if(info[k] == 0) unripeCnt++;
                    if(info[k] == 1){
                        queue.offer(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        int lastDepth = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            lastDepth = cur[3];

            for (int[] move : DIRECTION) {
                int nextH = cur[0] + move[0];
                int nextR = cur[1] + move[1];
                int nextC = cur[2] + move[2];
                int nextDepth = cur[3] + 1;

                if (nextH >= 0 & nextH < height && nextR >= 0 && nextR < row && nextC >= 0 && nextC < col) {
                    if (warehouse[nextH][nextR][nextC] == 0) {
                        unripeCnt--;
                        warehouse[nextH][nextR][nextC] = 1;
                        queue.offer(new int[]{nextH, nextR, nextC, nextDepth});
                    }
                }
            }
        }

        System.out.println(unripeCnt == 0 ? lastDepth : -1);

    }
}
