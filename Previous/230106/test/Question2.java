// 멀리 있는 애들끼리 비교해서 더 가까운 게 없으면 가장 최근에 비교한
// 멀리 있는 애들이 정답인데,

public class Question2 {
    int solution(int[] A) {
        int N = A.length;
        int result = 0;
        int temp = 0;
        for (int i = 0; i < N; i += 1) {
            for (int j = N - 1; j >= 0; j -= 1) {
                if (A[i] == A[j]) {
                    temp = Math.max(temp, Math.abs(i - j));

                    if (temp >= result) {
                        result = temp;
                        break;
                    }

                    return result;
                }
            }
        }
        return result;
    }
}
