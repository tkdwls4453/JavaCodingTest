package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 상자넣기
 *
 * 이름만 다르고 앞에 문제랑 같은 문제임, (가장 긴 감소하는 순열 찾기 문제)
 * 감소하는 것만 증가하도록 변경
 * */
public class BOJ1965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] mem = new int[n];

        Arrays.fill(mem, 1);

        int result = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    mem[i] = Math.max(mem[i], mem[j]+1);
                }
            }
            result = Math.max(mem[i], result);
        }

        System.out.println(result);
    }

}
