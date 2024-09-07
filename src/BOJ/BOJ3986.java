package BOJ;

import java.util.*;
import java.io.*;

/**
 * 선이 교차하는 지 찾기 위해 가까운 같은 문자 먼저 선으로 잇는다.
 * 스택 자료구조를 사용하여 현재 들어온 문자와 가장 마지막에 들어온 문자와 같다면 삭제해주면 된다. (연결된 문자)
 * 이를 반복 후 스택이 비어있다면 이는 좋은 단어이다.
 */
public class BOJ3986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            char[] arr = br.readLine().toCharArray();

            for (char c : arr) {
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }

            if(stack.isEmpty()) result++;
        }

        System.out.println(result);
    }
}
