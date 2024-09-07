package BOJ;

import java.util.*;
import java.io.*;

/**
 * 1 - 뒤에 추가
 * 2 - 앞에 추가
 * 3 - 마지막에 추가된 문자 삭제
 *
 * 마지막에 추가된 문자를 삭제하기 위해서 해당 index 를 저장하고 있어야 한다.
 * 여기서 마지막에 추가된 인덱스를 하나만 저장하고 있으면 연속으로 삭제 명령을 내릴 때 문제가 생기기 때문에
 * 문자를 추가할 때마다 추가된 인덱스를 저장하고 있어야 한다.
 * 가장 마지막에 추가된 인덱스를 찾아야 하기 때문에 스택 자료구조가 적절하다.
 *
 * 문자열을 만들기 위해 LinkedList 자료구조를 사용하였다.
 * ArrayList 는 읽기에는 효율적이지만 데이터를 추가하는데 비효율적이다.
 * LinkedList 는 데이터를 추가하는데 효율적이기 때문에
 * 이 문제에서는 LinkedList 자료구조가 적절하다.
 */

public class BOJ2749 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>();
        Stack<Integer> lastAddIdxStack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] inputArr = br.readLine().split(" ");
            String cmd = inputArr[0];
            String character = inputArr.length > 1 ? inputArr[1] : null;

            switch(cmd){
                case "1":
                    list.add(character);
                    lastAddIdxStack.add(list.size()-1);
                    break;
                case "2":
                    list.add(0, character);
                    lastAddIdxStack.add(0);
                    break;
                default:
                    if(!lastAddIdxStack.isEmpty()){
                        int lastAddIdx = lastAddIdxStack.pop();
                        list.remove(lastAddIdx);
                    }
                    break;
            }
        }

        for(String str : list){
            sb.append(str);
        }

        if(sb.length() == 0) System.out.println("0");
        else System.out.println(sb);
    }
}
