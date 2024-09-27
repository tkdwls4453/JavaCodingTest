package BOJ;

import java.util.*;
import java.io.*;

/**
 * 숫자판 펌프
 *
 * 임의의 위치에서 이동하면서 길이가 6인 가능한 모든 문자열을 만든다.
 * 완전 탐색하면 풀릴까? 크가가 5로 정해져 있어, 완전 탐색하여도 충분히 해결 가능해 보인다.
 * dfs 를 사용하여 완전탐색
 */
public class BOJ2210 {
    static final int MAP_SIZE = 5;
    static final int LEN = 6;
    static final Set<String> SET = new HashSet<>();
    static final String[][] MAP= new String[MAP_SIZE][MAP_SIZE];
    static final int[][] DIRECTION = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < MAP_SIZE; i++) {
            MAP[i] = br.readLine().split(" ");
        }

        for (int r = 0; r < MAP_SIZE; r++) {
            for (int c = 0; c < MAP_SIZE; c++) {
                dfs(r, c, new StringBuilder());
            }

        }

        System.out.println(SET.size());

    }

    public static void dfs(int row, int col, StringBuilder sb) {
        if (sb.length() == LEN) {
            SET.add(sb.toString());
            return;
        }

        for (int[] move : DIRECTION) {
            int nextR = row + move[0];
            int nextC = col + move[1];

            if (nextR >= 0 && nextR < MAP_SIZE & nextC >= 0 & nextC < MAP_SIZE) {
                sb.append(MAP[nextR][nextC]);
                dfs(nextR, nextC, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }


    }
}
