package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

/**
 * 패션왕 신해빈
 * 부위별로 의상이 주어지면 해당 의상들로 가능한 조합의 개수를 구해야 한다.
 * 부위별 의상의 개수를 체크하기 위해 HashMap 을 이용할 수 있다.
 *
 * 조합 개수 구하는 법
 * ex) 5 3 2
 * -> 5 + 3 + 2 +5*3 +5*2 +3*2 + 5*3*2 => 가능한 모든 조합을 구하면 시간 초과
 *
 * -> (5+1) * (3+1) * (2+1) -1
 * -> 해당의 상을 선택하지 않는 것을 생각해서 +1
 * -> -1 은 아무것도 선택하지 않는 경우는 없기 때문에
 */
public class BOJ9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int c = 0; c < cnt; c++) {
                String[] input = br.readLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }

//            List<Integer> values = map.values().stream().
//                    collect(Collectors.toList());

//            int result = 0;
//            for (int j = 1; j <= values.size(); j++) {
//                result += backtrack(j, 0, new ArrayList<>(), values, 0);
//            }

            int result = 1;
            for(int value : map.values()){
                result *= (value + 1);
            }


            System.out.println(result-1);
        }
    }

    public static int backtrack(int k, int start, List<Integer> cur, List<Integer> values, int result){
        if (k == cur.size()) {
            int tmp = 1;
            for(int num : cur){
                tmp *= num;
            }

            result += tmp;
            return result;
        }

        for (int i = start; i < values.size(); i++) {
            cur.add(values.get(i));
            result = backtrack(k, i+1, cur, values, result);
            cur.remove(cur.size() - 1);
        }

        return result;
    }
}
