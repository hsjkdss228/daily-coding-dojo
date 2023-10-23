// 문제 풀이 과정
// 1. 준비
//   - 도난당한 학생 배열을 정렬
//   - 참여 가능한 학생 수 = 전체 학생 수 - 도난당한 학생 수
//   - 여벌 체육복을 가진 학생이 체육복을 빌려줬는지 체크하는 맵을 선언
//     이때 여벌 체육복을 가졌으나 도난당한 학생일 경우 맵에 추가하지 않고
//     여벌 체육복을 가졌으나 도난당한 학생 리스트에 추가, 참여 가능한 학생 수에 +1
// 2. 풀이
//   - 체육복을 도난당한 학생 각각에 대해 다음의 작업 수행
//     - 여벌 체육복을 가졌으면서 도난당한 학생이면 작업을 수행하지 않고 통과
//     - 여벌 체육복이 없는 학생이라면
//       앞뒤 학생 중 여벌이 있는 학생이 있는지 확인
//     - 있으면 해당 여벌이 있는 학생의 여벌 보유 여부를 false로 변경하고
//       참여 가능한 학생 수에 +1
//
// * 체육복을 도난당한 학생 각각을 얻어오는 배열을 정렬해줘야 함, 그 이유는?
//   다음의 예시를 생각해보자.
//   1     2     3     4     5
//       도[1]        도[0]
//              여벌         여벌
//
//   정렬되어 있지 않은 도난당한 학생 배열을 하나씩 가져올 경우
//   4번 학생부터 먼저 3번, 5번 학생에 여벌이 있는지 탐색하여
//   앞선 학생의 여벌을 먼저 빌리도록 하는 구조로 구현된 경우에는 3번 학생의 여벌을 빌림
//   이렇게 되면 2번 학생은 여벌을 빌릴 수 없으며, 만약 2번 학생부터 순차적으로
//   여벌이 있는 학생을 탐색했을 경우 2번 학생과 4번 학생 모두 여벌을 빌릴 수 있었음에도 불구하고
//   2번 학생이 여벌을 빌리지 못하게 되어 수업에 참여 가능한 학생 수의 최대값인 5를 만족하지 못함
//
//   따라서 도난당한 학생 배열을 정렬하여 2번 학생, 4번 학생의 오름차순 순서대로
//   주변 학생 여벌 탐색을 수행하도록 해야 함

import java.util.*;

public class Uniform {
  private int studentsCountCanTakeClasses;

  private Map<Integer, Boolean> hasLentClothes;

  public int solution(
      int studentNumber,
      int[] studentsLostClothes, int[] studentsHasExtraClothes) {
    Arrays.sort(studentsLostClothes);

    studentsCountCanTakeClasses
        = studentNumber - studentsLostClothes.length;

    hasLentClothes = new HashMap<>();
    List<Integer> haveExtraButLost = new ArrayList<>();

    for (int studentHasExtraClothes : studentsHasExtraClothes) {
      boolean studentHaveExtraButLost = false;

      for (int studentLostClothes : studentsLostClothes) {
        if (studentLostClothes == studentHasExtraClothes) {
          haveExtraButLost.add(studentHasExtraClothes);

          studentsCountCanTakeClasses += 1;

          studentHaveExtraButLost = true;
          break;
        }
      }

      if (!studentHaveExtraButLost) {
        hasLentClothes.put(studentHasExtraClothes, false);
      }
    }

    for (int studentLostClothes : studentsLostClothes) {
      if (haveExtraButLost.contains(studentLostClothes)) {
        continue;
      }

      if (checkAnotherStudentIfHaveExtraClothes(studentLostClothes - 1)) {
        continue;
      }

      checkAnotherStudentIfHaveExtraClothes(studentLostClothes + 1);
    }

    return studentsCountCanTakeClasses;
  }

  private boolean checkAnotherStudentIfHaveExtraClothes(int studentIndex) {
    if (hasLentClothes.containsKey(studentIndex)
        && !hasLentClothes.get(studentIndex)) {
      hasLentClothes.replace(studentIndex, true);
      studentsCountCanTakeClasses += 1;
      return true;
    }

    return false;
  }
}
