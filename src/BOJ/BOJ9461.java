package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 파도반 수열
 *
 * 점화식
 * f(n) = f(n-1) + f(n-5)
 */
public class BOJ9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[] mem = new long[101];
        Arrays.fill(mem, -1);

        mem[0] = 1; mem[1] = 1; mem[2] = 1; mem[3] = 2; mem[4] = 2;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp(mem, n-1));
        }
    }

    public static long dp(long[] mem, int n){
        if (mem[n] != -1) {
            return mem[n];
        }

        mem[n] = dp(mem, n - 1) + dp(mem, n - 5);
        return mem[n];
    }
}
