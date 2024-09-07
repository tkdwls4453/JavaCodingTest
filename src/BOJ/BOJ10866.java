package BOJ;

import java.util.*;
import java.io.*;

/**
 * 덱 자료구조를 구현하는 문제이다.
 * 데이터의 삽입과 삭제가 많이 발생하기 때문에 LinkedList 를 사용하여 덱 자료구조를 구현하였다.
 */
public class BOJ10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputArr = br.readLine().split(" ");
            String cmd = inputArr[0];
            Integer content = inputArr.length > 1 ? Integer.parseInt(inputArr[1]) : null;

            switch(cmd){
                case "push_front":
                    list.add(0, content);
                    break;
                case "push_back":
                    list.add(content);
                    break;
                case "pop_front":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.remove(0));
                    }
                    break;
                case "pop_back":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.remove(list.size() - 1));
                    }
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    System.out.println(list.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.get(0));
                    }
                    break;
                case "back":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.get(list.size() - 1));
                    }
                    break;
            }
        }
    }
}
