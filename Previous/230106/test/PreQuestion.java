// A에 포함되지 않은 0 이상의 가장 작은 양의 정수를 반환
// 효율적으로 짜세요
// A의 길이: 1~100,000
// 각 요소의 범위: -1,000,000~1,000,000

// A에는 같은 수가 있을 수도 있음

import java.util.Arrays;

class PreQuestion {
    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 1; i += 1) {
            if (A[i] <= 0) {
                continue;
            }

            if (!(A[i + 1] - A[i] == 0 || A[i + 1] - A[i] == 1)) {
                return A[i] + 1;
            }
        }

        if (A[A.length - 1] <= 0) {
            return 1;
        }

        return A[A.length - 1] + 1;
    }
}

// 결과
// 예시 3/3
// 정확성 1/5
// 효율성 4/4
