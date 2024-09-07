package BOJ;

import java.util.*;
import java.io.*;

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
