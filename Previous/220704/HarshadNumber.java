public class HarshadNumber {
  public boolean solution(int x) {
    int divisor = makeDivisor(x);
    //int divisor = makeDivisorInADifferentWay(x);

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
    return Integer.toString(x)      //135 >> "135"
        .chars()                    //'1' '3' '5'
        .map(digit -> digit - '0')  //'뭐시기' << 1, '거시기' << 3, '저시기' << 5
        .sum();                     //1 + 3 + 5
  }
}
