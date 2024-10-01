package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * 스카이라인 쉬운거
 */
public class BOJ1863 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int cnt = 0;

        while (n-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            int  y = input[1];

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                cnt++;
            }

            if(y==0) continue;

            if(stack.isEmpty()) stack.push(y);
            else if(stack.peek() != y) stack.push(y);

        }

        System.out.println(cnt + stack.size());
    }
}
