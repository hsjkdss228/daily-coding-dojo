public class Summation {
  public int solution(int[] absolutes, boolean[] signs) {
    int result = 0;

    for (int i = 0; i < absolutes.length; i += 1) {
      if (signs[i]) {
        result += absolutes[i];
      }
      if (!signs[i]) {
        result -= absolutes[i];
      }
    }

    return result;
  }
}
