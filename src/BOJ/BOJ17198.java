package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Bucket Bridgade
 *
 * 간단하게 요약하면 호수에서 물을 떠다 불을 끄기 위한 최단 거리를 구하는 문제이다. 중간에 바위도 있고 그곳은 이동하지 못한다.
 * 배열을 10 x 10 으로 고정, 불, 호수, 바위의 위치가 주어진다.
 * 풀이
 *  호수로 부터 불까지 가기 위한 최소 거리는 BFS 로 풀 수 있다.
 *  가려고 하는 다음 위치가 바위인지만 체크하면서 가면된다.
 */
public class BOJ17198 {
    static final int[] BURN = new int[2], ROCK = new int[2], LAKE = new int[2];
    static final int SIZE = 10;
    static final boolean visited[][] = new boolean[SIZE][SIZE];

    static final int[][] DIRECTION = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs()-1);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < 10; j++) {
                switch (input[j]) {
                    case 'B':
                        BURN[0] = i;
                        BURN[1] = j;
                        break;
                    case 'R':
                        ROCK[0] = i;
                        ROCK[1] = j;
                        break;
                    case 'L':
                        LAKE[0] = i;
                        LAKE[1] = j;
                }
            }

        }
    }

    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{LAKE[0], LAKE[1], 0});
        visited[LAKE[0]][LAKE[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(isBurn(cur)){
                return cur[2];
            }

            for (int[] move : DIRECTION) {
                int nextR = cur[0] + move[0];
                int nextC = cur[1] + move[1];
                int nextDepth = cur[2] + 1;

                if (nextR >= 0 && nextR < SIZE && nextC >= 0 && nextC < SIZE) {
                    if (!visited[nextR][nextC] && !isRock(nextR, nextC)) {
                        visited[nextR][nextC] = true;
                        queue.offer(new int[]{nextR, nextC, nextDepth});
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isRock(int row, int col) {
        return row == ROCK[0] && col == ROCK[1];
    }

    public static boolean isBurn(int[] cur){
        return cur[0] == BURN[0] && cur[1] == BURN[1];
    }

}
