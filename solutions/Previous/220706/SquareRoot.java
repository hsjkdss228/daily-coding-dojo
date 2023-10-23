public class SquareRoot {
  public long solution(long number) {
    double squareRootNumber = Math.sqrt(number);

    if (isMathematicallyInteger(squareRootNumber)) {
      return (long) Math.pow(squareRootNumber + 1, 2);
    }

    return -1;
  }

  public boolean isMathematicallyInteger(double squareRootNumber) {
    return squareRootNumber - Math.floor(squareRootNumber) == 0;
  }
}
