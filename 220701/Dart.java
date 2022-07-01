import java.util.ArrayList;
import java.util.List;

public class Dart {
  public int solution(String dartResult) {
    List<Integer> sets = new ArrayList<>();

    int score = 0;
    int bonus = 0;

    boolean scoreIsChecked = false;
    boolean bonusIsChecked = false;

    for (int i = 0; i < dartResult.length(); i += 1) {
      char letter = dartResult.charAt(i);

      //점수
      if (letter >= '0' && letter <= '9') {
        if (letter == '1' && dartResult.charAt(i + 1) == '0') {
          score = 10;
          i += 1;
        } else {
          score = Character.getNumericValue(letter);
        }
        scoreIsChecked = true;
        continue;
      }

      //보너스
      if (letter == 'S' || letter == 'D' || letter == 'T') {
        bonus = switch (letter) {
          case 'S' -> 1;
          case 'D' -> 2;
          case 'T' -> 3;
          default -> Integer.MIN_VALUE;
        };
        bonusIsChecked = true;
      }

      //점수, 보너스가 모두 체크되었으면 계산해서 결과에 합산
      if (scoreIsChecked && bonusIsChecked) {
        sets.add((int) Math.pow(score, bonus));

        scoreIsChecked = false;
        bonusIsChecked = false;
      }

      //옵션이 있으면 결과 배열 값에 옵션을 반영
      int lastIndexOfSets = sets.size() - 1;

      if (i + 1 < dartResult.length()) {
        switch (dartResult.charAt(i + 1)) {
          case '*' -> {
            if (sets.size() >= 2) {
              sets.set(lastIndexOfSets - 1, sets.get(lastIndexOfSets - 1) * 2);
            }

            sets.set(lastIndexOfSets, sets.get(lastIndexOfSets) * 2);

            i += 1;
          }
          case '#' -> {
            sets.set(lastIndexOfSets, sets.get(lastIndexOfSets) * -1);

            i += 1;
          }
        }
      }
    }

    return sets.stream()
        .mapToInt(resultOfSet -> resultOfSet)
        .sum();
  }
}
