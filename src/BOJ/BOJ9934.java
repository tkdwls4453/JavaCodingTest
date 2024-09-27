package BOJ;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * 완전 이진 트리
 *
 * 문제를 해석해보면 중위 순회로 방문한 정보를 가지고 트리를 구성하라는 문제이다.
 **/
public class BOJ9934 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[] tree = new int[(int) Math.pow(2, K) - 1];

        // 가장 처음 위치는 가장 오른쪽 리프 노드의 부모에서 시작한다.
        int start = Math.max(0, (int) Math.pow(2, K - 2) - 1);

        List<Integer> visitSeq = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!visitSeq.isEmpty()) {
            start = visit(tree, start, visitSeq);
        }

        printTree(tree);
    }

    public static int visit(int[] tree, int curIdx, List<Integer> visitSeq) {
        int leftIdx = curIdx * 2 + 1;
        int rightIdx = curIdx * 2 + 2;

        // 왼쪽 노드에 방문하지 않았다면 왼쪽 이동
        if (leftIdx < tree.length && tree[leftIdx] == 0) {
            visit(tree, leftIdx, visitSeq);
        }

        tree[curIdx] = visitSeq.remove(0);

        // 오른쪽 노드 이동
        if(rightIdx < tree.length && tree[rightIdx] == 0) {
            visit(tree, rightIdx, visitSeq);
        }

        return curIdx/2;
    }
    public static void printTree(int[] tree){
        int depth = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tree.length; i++) {
            if (i == Math.pow(2, depth)-1) {
                sb.append("\n");
                depth++;
            }
            sb.append(tree[i]).append(" ");
        }

        System.out.println(sb);
    }
}
