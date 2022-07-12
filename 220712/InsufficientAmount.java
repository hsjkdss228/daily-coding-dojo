public class InsufficientAmount {
  public long solution(int price, int money, int count) {
    long moneyNeeded = 0;

    for (int i = 1; i <= count; i += 1) {
      moneyNeeded += ((long) price) * i;
    }

    if (moneyNeeded - money < 0) {
      return 0;
    }

    return moneyNeeded - money;
  }
}
