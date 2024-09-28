package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1406 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> left = new ArrayDeque<>();
        Deque<String> right = new ArrayDeque<>();

        String str = br.readLine();

        for(String s : str.split("")){
            left.addLast(s);
        }

        int cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++){
            String[] input = br.readLine().split(" ");
            String command = input[0];
            String value = null;

            if(input.length != 1){
                value = input[1];
            }

            switch(command){
                case "L":
                    if(!left.isEmpty()){
                        right.addLast(left.removeLast());
                    }
                    break;
                case "D":
                    if(!right.isEmpty()){
                        left.addLast(right.removeLast());
                    }
                    break;
                case "B":
                    if(!left.isEmpty()){
                        left.removeLast();
                    }
                    break;
                case "P":
                    left.addLast(value);
                    break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (!left.isEmpty()) {
            bw.write(left.removeFirst());
        }

        while (!right.isEmpty()) {
            bw.write(right.removeLast());
        }

        bw.flush();
        bw.close();
    }
}
