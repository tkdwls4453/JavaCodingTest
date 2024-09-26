package BOJ;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ1966 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t=0; t<test; t++){
            String[] input = br.readLine().split(" ");
            int targetIdx = Integer.parseInt(input[1]);

            List<Integer> list = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Queue<int[]> queue = new LinkedList<>();

            for(int i=0; i<list.size(); i++){
                queue.offer(new int[]{i, list.get(i)});
            }

            Collections.sort(list, (o1, o2) -> {
                return o2 - o1;
            });

            int cnt = 0;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();

                if (poll[1] == list.get(0)) {
                    cnt++;
                    list.remove(0);
                    if (poll[0] == targetIdx) break;
                }else {
                    queue.offer(poll);
                }
            }

            System.out.println(cnt);
        }
    }
}
