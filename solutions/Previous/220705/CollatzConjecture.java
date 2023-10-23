public class CollatzConjecture {
  public int solution1(int number) {
    if (number == 1) {
      return 0;
    }

    int modifiedNumber = number;
    int modifyingCount = 0;

    while (modifiedNumber != 1) {
      if (modifyingCount >= 500) {
        return -1;
      }

      switch (modifiedNumber % 2) {
        case 0 -> modifiedNumber /= 2;
        case 1 -> modifiedNumber = (modifiedNumber * 3) + 1;
      }

      modifyingCount += 1;
    }

    return modifyingCount;
  }

  public int solution2(int number) {
    int modifyingCount = 0;

    return modifyNumberRecursively(number, modifyingCount);
  }

  public int modifyNumberRecursively(long modifiedNumber, int modifyingCount) {
    if (modifiedNumber == 1) {
      return modifyingCount;
    }
    if (modifyingCount >= 500) {
      return -1;
    }

    /*System.out.println("modifiedNumber = " + modifiedNumber +
        ",  modifiedNumber % 2 = " + modifiedNumber % 2);*/

    /*if (modifiedNumber % 2 == 0) {
      return modifyNumberRecursively(modifiedNumber / 2, modifyingCount + 1);
    }
    if (modifiedNumber % 2 == 1) {
      return modifyNumberRecursively((modifiedNumber * 3) + 1, modifyingCount + 1);
    }*/

    return switch ((int) (modifiedNumber % 2)) {
      case 0 -> modifyNumberRecursively(modifiedNumber / 2, modifyingCount + 1);
      case 1 -> modifyNumberRecursively((modifiedNumber * 3) + 1, modifyingCount + 1);
      default ->
          throw new IllegalStateException("Unexpected value: " + modifiedNumber % 2);
    };
  }
}
