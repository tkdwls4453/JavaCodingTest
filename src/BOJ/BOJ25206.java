package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 너의 평점은
 */
public class BOJ25206 {
    static Map<String, Double> gradeTable = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initTable();

        double total = 0.0;
        double sum = 0.0;
        int cnt = 20;
        while (cnt-- > 0) {
            String[] info = br.readLine().split(" ");

            if(info[2].equals("P")) continue;

            total += Double.parseDouble(info[1]);
            sum += Double.parseDouble(info[1]) * gradeTable.get(info[2]);
        }

        double result = 0.0;

        if (total != 0) {
            result = sum / total;
        }

        System.out.printf("%.6f", result);
    }

    public static void initTable(){
        gradeTable.put("A+", 4.5);
        gradeTable.put("A0", 4.0);
        gradeTable.put("B+", 3.5);
        gradeTable.put("B0", 3.0);
        gradeTable.put("C+", 2.5);
        gradeTable.put("C0", 2.0);
        gradeTable.put("D+", 1.5);
        gradeTable.put("D0", 1.0);
        gradeTable.put("F", 0.0);
    }

}
