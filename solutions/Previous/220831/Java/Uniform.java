// 1. 주어지는 배열들의 모든 원소를 1씩 빼서 학생들 번호를 배열 인덱스와 일치시켜준 뒤 List로 변환
// 2. lost와 reserve에 중복 숫자가 있으면 탐색에서 제외되는 값으로 변경
// 3. lost와 reserve를 정렬 (lost와 reserver가 정렬되지 않았을 가능성이 있는데,
//                         정렬되지 않았으면 대여 방향에 따라 최적의 대여를 하지 못할 수 있음)
// 4. lost를 순차적으로 탐색
//   4-1. lost에서 가져온 하나의 값의 -1이나 +1에 해당하는 숫자가 reserve에 있으면
//        lost에서 가져온 값과 해당되는 reserve 값을 탐색에서 제외되는 값으로 변경
// 5. n - lost에서 탐색되는 상태로 남아있는 학생들의 수

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Uniform {
  private static final Integer EXCLUDED = Integer.MIN_VALUE;

  public int solution(int studentsCount, int[] lost, int[] reserve) {
    List<Integer> studentsLost = Arrays.stream(lost)
        .boxed()
        .collect(Collectors.toList());

    List<Integer> studentsReserved = Arrays.stream(reserve)
        .boxed()
        .collect(Collectors.toList());

    studentsReserved.forEach(studentReserved -> {
      if (studentsLost.contains(studentReserved)) {
        studentsLost.set(studentsLost.indexOf(studentReserved), Uniform.EXCLUDED);
        studentsReserved.set(studentsReserved.indexOf(studentReserved), Uniform.EXCLUDED);
      }
    });

    studentsLost.sort(Comparator.naturalOrder());
    studentsReserved.sort(Comparator.naturalOrder());

    studentsLost.forEach(student -> {
      if (student.equals(Uniform.EXCLUDED)) {
        return;
      }

      if (studentsReserved.contains(student - 1)) {
        studentsLost.set(studentsLost.indexOf(student), Uniform.EXCLUDED);
        studentsReserved.set(studentsReserved.indexOf(student - 1), Uniform.EXCLUDED);
        return;
      }

      if (studentsReserved.contains(student + 1)) {
        studentsLost.set(studentsLost.indexOf(student), Uniform.EXCLUDED);
        studentsReserved.set(studentsReserved.indexOf(student + 1), Uniform.EXCLUDED);
      }
    });

    int studentsLostCount = (int) studentsLost.stream()
        .filter(student -> !student.equals(Uniform.EXCLUDED))
        .count();

    return studentsCount - studentsLostCount;
  }
}
