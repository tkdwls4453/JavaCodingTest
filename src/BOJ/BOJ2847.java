package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 게임을 만든 동준
 */
public class BOJ2847 {
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            decreaseAndPush(stack, num);
        }

        System.out.println(result);
    }

    public static void decreaseAndPush(Stack<Integer> stack, int num) {
        if (stack.isEmpty() || stack.peek() < num) {
            stack.push(num);
            return;
        }

        int prev = stack.pop();
        result += prev - (num - 1);
        prev = num - 1;
        decreaseAndPush(stack, prev);
        stack.push(num);
    }
}
