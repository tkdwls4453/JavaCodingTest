package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 신입사원
 *
 * 신입 사원의 조건은 모든 지원자들과 비교했을 때, 서류 심사, 면접 심사의 성적 중 하나라도 다른 지원자보다 떨어지면 안된다.
 * 입력의 크기는 10^5 이다. N^2 은 통과하기 힘들 것 같다. 시간 제한이 2초 이지만, 테스트 케이스도 20 번임.
 * 그럼 가장 처음 생각났던 방법인 지원자 한명 한명, 점수를 비교하는 것은 힘들다.
 * 스택, 큐 등 적절한 자료구조를 적용하던지, 정렬을 사용할 수 있는 지 생각해보았다. -> 순위 관련 문제로 정렬을 시도해보기로 함.
 * 어떻게 정렬하지?
 *  우선 서류 기준으로 내림차순으로 정렬한다.
 *  -> 서류 순으로 정렬했기 때문에, 나의 뒤에 있는 지원자는 나보다 서류 등수가 좋다, 그렇기 때문에 뒷사람과 비교해서 면접 점수가 좋아야만 합격 가능하다.
 *  -> 뒷사람과 비교해 면접 등수가 작으면 합격
 *  -> 뒷사람과 서류 등수가 같은 경우도 있기 때문에 서류 등수가 같은 상황에는 면접 등수 기준으로 내림 차순하면 된다.
 *  앞쪽에 있는 사람은 자신의 뒤쪽에 있는 사람들 보다 등수가 무조건 낮거나 같아야 한다. -> 앞의 원소와 연관이 있어 stack 자료구조 이용
 */
public class BOJ1946{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> grades = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int[] input = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                grades.add(input);
            }

            Collections.sort(grades, (o1, o2) -> {
                if (o1[0] == o2[0]) return o1[2] - o2[2];
                return o2[0] - o1[0];
            });

            Deque<Integer> stack = new ArrayDeque<>();

            for (int j = 0; j < grades.size(); j++) {

                while (!stack.isEmpty() && grades.get(j)[1] < stack.peek()) {
                    stack.pop();
                }

                stack.push(grades.get(j)[1]);
            }

            System.out.println(stack.size());
        }
    }
}
