// 문제 풀이 과정
// - 여벌 체육복을 가진 학생 중 도난당한 학생이 있는지 확인
//
//
// - 체육복을 도난당한 학생 각각에 대해
// - 앞뒤 학생 중 여벌이 있는 학생이 있는지 확인
//   있으면 여벌이 있는 학생의 여벌 보유 여부를 false로 변경 (해당 학생의 여벌을 빌림)
// - 앞뒤 학생 중 여벌이 없으면 본인이 여벌이 있는지 확인
//   있으면 본인의 여벌 보유 여부를 false로 변경 (본인이 본인의 여벌을 빌림)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uniform {
  // 여벌을 가진 학생이 여벌을 빌려줬는지 체크하는 맵 변수
  private Map<Integer, Boolean> hasLentClothes;
  List<Integer> haveExtraButLost;

  public int solution(
      int studentNumber,
      int[] studentsLostClothes, int[] studentsHasExtraClothes) {
    int studentsCountCanTakeClasses = studentNumber - studentsLostClothes.length;

    hasLentClothes = new HashMap<>();
    haveExtraButLost = new ArrayList<>();

    for (int studentHasExtraClothes : studentsHasExtraClothes) {
      boolean haveExtraButLost = false;

      for (int studentLostClothes : studentsLostClothes) {
        if (studentHasExtraClothes == studentLostClothes) {
          haveExtraButLost = true;

          this.haveExtraButLost.add(studentHasExtraClothes);

          studentsCountCanTakeClasses += 1;
          break;
        }
      }

     if (!haveExtraButLost) {
       hasLentClothes.put(studentHasExtraClothes, false);
     }
    }

    for (int studentLostClothes : studentsLostClothes) {
      if (hasLentClothes.containsKey(studentLostClothes - 1)
          && !haveExtraButLost.contains(studentLostClothes - 1)
          && !hasLentClothes.get(studentLostClothes - 1)) {
        hasLentClothes.replace(studentLostClothes - 1, true);
        studentsCountCanTakeClasses += 1;
        continue;
      }

      if (hasLentClothes.containsKey(studentLostClothes + 1)
          && !haveExtraButLost.contains(studentLostClothes + 1)
          && !hasLentClothes.get(studentLostClothes + 1)) {
        hasLentClothes.replace(studentLostClothes + 1, true);
        studentsCountCanTakeClasses += 1;
      }
    }

    return studentsCountCanTakeClasses;
  }
}
