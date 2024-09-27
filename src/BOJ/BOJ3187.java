package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 양치기 꿍
 *
 * 울타리 안에 양보다 늑대가 많으면 양이 전부 죽고, 양이 많으면 늑대가 전부 죽는다.
 * 울타리 안을 탐색하면서 양이 많은 지 늑대가 많은 지 카운트하여 많은 쪽을 최종 카운트에 추가하면 된다.
 * 탐색을 위해서는 DFS 알고리즘을 사용한다.
 * 행과 열이 최대 250이기 때문에 전부 탐색해도 250 * 250 으로 충분하다고 판단
 */
public class BOJ3187 {
    static final int[][] DIRECTION = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int wolf = 0;
    static int sheep = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int rowSize = Integer.parseInt(input[0]);
        int colSize = Integer.parseInt(input[1]);

        char[][] graph = new char[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {

                // 늑대와 양의 개수를 카운트하기 위한
                int[] cntArr = new int[2];

                switch (graph[r][c]){
                    case 'v':
                        cntArr[0]++;
                        break;
                    case 'k':
                        cntArr[1]++;
                        break;
                }
                dfs(r, c, cntArr, graph);

                if(cntArr[0] < cntArr[1]) sheep += cntArr[1];
                else wolf += cntArr[0];
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static void dfs(int row, int col, int[] cntArr, char[][] graph) {

        for (int[] move : DIRECTION) {
            int nextR = row + move[0];
            int nextC = col + move[1];

            if (nextR >= 0 && nextR < graph.length && nextC >= 0 && nextC < graph[0].length && graph[nextR][nextC] != '#') {
                switch (graph[nextR][nextC]){
                    case 'v':
                        cntArr[0]++;
                        break;
                    case 'k':
                        cntArr[1]++;
                        break;
                }
                graph[nextR][nextC] = '#';
                dfs(nextR, nextC, cntArr, graph);
            }
        }
    }
}
