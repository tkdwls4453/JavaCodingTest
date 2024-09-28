package BOJ;

import java.util.*;
import java.io.*;

/**
 * 30번
 *
 * 이진 트리에 데이터가 1부터 순서대로 채워져 있다.
 * 따라서 현재 노드의 부모 값은 현재 노드값에서 2를 나누면 쉽게 구할 수 있다.
 * a 와 b 중 더 큰 값을 2로 나누어 부모값으로 업데이트한다. 이를 a와 b가 같을 때까지 반복하면 된다.
 */
public class BOJ13116 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            while (a != b) {
                if(a > b) a = a / 2;
                else b = b / 2;
            }

            sb.append(a * 10).append("\n");
        }

        System.out.println(sb);
    }

}
