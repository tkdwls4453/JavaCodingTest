package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 방양갱
 *
 * 맨 처음 3 +2 + 1 + 2 = 8
 * 맨 마지막 2 는 고정 , 최소 10 고정
 * 1 - 0
 * 2 - 1
 * 3 - 2
 * 4 - 2
 * 5 - 3
 * 6 - 3
 * 7 - 3
 * 8 - 3
 * 9 - 4
 * 9
 * 1 + 1 + 1
 * 8
 * a a a a a a a a
 * 1 2 4 8
 */

public class BOJ31926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cur = 1;
        int result = 0;

        while (cur * 2 <= n) {
            cur = cur * 2;
            result++;
        }

        System.out.println(result + 10);

    }
}
