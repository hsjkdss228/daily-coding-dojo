public class InsufficientAmount {
  // 반복문을 활용한 풀이
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

  // 재귀를 활용한 풀이
  private int price;
  private int money;
  private int maxCount;

  public long solution2(int price, int money, int count) {
    this.price = price;
    this.money = money;
    this.maxCount = count;

    long totalPrice = priceCalculate(price, 1);

    return totalPrice > 0
        ? totalPrice
        : 0;
  }

  public long priceCalculate(long currentPrice, long currentCount) {
    if (currentCount >= maxCount) {
      return currentPrice - money;
    }

    return priceCalculate(currentPrice + price * (currentCount + 1), currentCount + 1);

    // maxCount가 처음에는 네이밍이 count로 되어 있었는데,
    // 그 때문에 currentCount를 써야 하는 지점에서 이름을 헷갈리는 바람에
    // count를 써버려서 연산이 설계한 대로 이뤄지지 않았던 문제가 있었음
    // 헷갈리지 않게 명확하게 구분이 되는 네이밍이 중요하다!
  }
}
