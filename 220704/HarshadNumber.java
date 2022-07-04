public class HarshadNumber {
  public boolean solution(int x) {
    int divisor = makeDivisor(x);
    divisor = makeDivisorInADifferentWay(x);

    return (x % divisor == 0);
  }

  public int makeDivisor(int x) {
    int dividend = x;
    int divisor = 0;

    while (dividend > 0) {
      divisor += dividend % 10;
      dividend /= 10;
    }

    return divisor;
  }

  public int makeDivisorInADifferentWay(int x) {
    return Integer.toString(x)
        .chars()
        .map(digit -> digit - '0')
        .sum();
  }
}
