package BOJ;

import java.util.*;
import java.io.*;

/**
 * 스택 자료구조를 사용하였다.
 * '(' 는 그 다음에 오는 ')' 한쌍이 되고 '[' 역시 다음 ']' 과 한쌍이 된다.
 * 스택에 열리는 괄호가 들어오면 넣어주고 닫히는 괄호가 들어오면 최근 들어간 괄호가 무엇인지 체크하고
 * 맞는 괄호라면 스택에서 빼고 다른 괄호라면 실패시킨다.
 */

public class BOJ4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = br.readLine();

            if(input.equals(".")) break;
            Stack<Character> stack = new Stack<>();

            boolean fail = false;
            for(char c : input.toCharArray()){
                switch(c){
                    case '(':
                        stack.push(')');
                        break;
                    case ')':
                        if(!stack.isEmpty() && stack.peek() == c){
                            stack.pop();
                        }else{
                            fail = true;
                        }
                        break;
                    case '[':
                        stack.push(']');
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek() == c){
                            stack.pop();
                        }else{
                            fail = true;
                        }
                        break;
                    default:
                        break;
                }
                if(fail) break;
            }

            if(!stack.isEmpty() || fail) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
