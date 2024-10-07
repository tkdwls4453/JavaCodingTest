package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 마인크래프트
 *
 * min 높이 ~ max 높이까지 하나하나 비용을 계산하고 비교하였다.
 * 시간 복잡도는 괜찮을까?
 * 배열의 크기가 250000 이고 최대 높이가 256 이기 때문에 넉넉하진 않지만 가능할듯
 */


public class BOJ18111 {
    private static final int MAX_LAND_HEIGHT = 256;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int r = input[0], c = input[1], inventory = input[2];
        int[][] land = new int[r][c];

        int maxHeight = -1;
        int minHeight = MAX_LAND_HEIGHT + 1;

        // 비용, 높이 저장
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;

        for (int i = 0; i < r; i++) {
            land[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            maxHeight = Math.max(Arrays.stream(land[i]).max().getAsInt(), maxHeight);
            minHeight = Math.min(Arrays.stream(land[i]).min().getAsInt(), minHeight);
        }

        for (int height = minHeight; height <= maxHeight; height++) {
            int cost = calculateCost(land, inventory, height);
            if (cost <= result[0]) {
                result[0] = cost;
                result[1] = height;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

    public static int calculateCost(int[][] land, int inventory, int height) {
        int cntPlus = 0;
        int cntMinus = 0;

        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {
                if (land[r][c] <= height) {
                    cntPlus += (height - land[r][c]);
                }

                if (land[r][c] > height) {
                    cntMinus += (land[r][c] - height);
                }
            }
        }

        if (cntPlus > cntMinus + inventory) {
            return Integer.MAX_VALUE;
        }

        return cntMinus * 2 + cntPlus;
    }
}
