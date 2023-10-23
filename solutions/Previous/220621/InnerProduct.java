public class InnerProduct {
  public int solution(int[] a, int[] b) {
    int innerProduct = 0;

    for (int i = 0; i < a.length; i += 1) {
      innerProduct += a[i] * b[i];
    }

    return innerProduct;
  }
}
