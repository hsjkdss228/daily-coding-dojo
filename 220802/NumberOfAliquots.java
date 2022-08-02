// 어떤 수의 약수를 구하는 방법?
// 주어진 수를 1부터 해당 숫자 크기까지 1씩 늘려 가며 나눴을 때 나머지가 0인지 확인
// 0이면 나눈 수는 해당 수의 약수

public class NumberOfAliquots {
  public int solution(int left, int right) {
    int answer = 0;

    for (int i = left; i <= right; i += 1) {
      int aliquotsCount = 0;

      for (int divisor = 1; divisor <= i; divisor += 1) {
        if (i % divisor == 0) {
          aliquotsCount += 1;
        }
      }

      if (aliquotsCount % 2 == 0) {
        answer += i;
        continue;
      }
      answer -= i;
    }

    return answer;
  }
}
