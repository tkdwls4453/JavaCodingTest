package BOJ;

/**
 * 좌표 압축
 */

import java.util.*;
import java.io.*;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        int[] result = new int[n];

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{input[i], i};
        }

        Arrays.sort(arr, (o1,o2) -> {
            return o1[0] - o2[0];
        });

        int lastCnt = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1][0] != arr[i][0]) {
                lastCnt++;
            }
            result[arr[i][1]] = lastCnt;
        }

        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
