public class Day {
  public String solution(int month, int date) {
    int[] numberOfDaysPerMonth = {
        0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    int daysCount = 0;
    for (int i = 1; i <= month - 1; i += 1) {
      daysCount += numberOfDaysPerMonth[i];
    }

    daysCount += date;

    return switch (daysCount % 7) {
      case 1 -> "FRI";
      case 2 -> "SAT";
      case 3 -> "SUN";
      case 4 -> "MON";
      case 5 -> "TUE";
      case 6 -> "WED";
      case 0 -> "THU";
      default -> "";
    };
  }
}
