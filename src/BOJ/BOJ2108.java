package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 통계학
 */
public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            max = Math.max(num, max);
            min = Math.min(num, min);

            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum += num;
        }

        int maxCnt = 0;
        for (int key : map.keySet()) {
            maxCnt = Math.max(maxCnt, map.get(key));
        }
        List<Integer> cntList = new ArrayList<>();

        Collections.sort(list);

        for (int num : list) {
            if (map.get(num) == maxCnt) {
                if (!cntList.contains(num)) {
                    cntList.add(num);
                }
            }
        }
        long avg = Math.round(sum / n);
        int mid = list.get(n / 2);
        int m = cntList.size() > 1 ? cntList.get(1) : cntList.get(0);
        int range = max - min;

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(m);
        System.out.println(range);

    }
}
