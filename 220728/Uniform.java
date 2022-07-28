// 예시
// 전체 학생: 8명
// 자기 물건 하나 간수 못하는 바보들: 1 3 4 6 7
// 여벌의 체육복을 가져온 학생: 2 5 6
// 여벌 체육복 가져온 학생이 빌려줬는지 확인하는 boolean 배열 두기
//
// 먼저 여벌의 체육복을 가져온 학생 중 바보가 있는지 확인
// 여벌의 체육복을 가져왔는데 바보면 여벌을 빌려준 상태를 true로 전환
//
// 바보들 수만큼 반복
//  참여 가능 학생을 일단 8명으로 두고 시작
//  1번 바보:
//    (앞번호는 없고) 2번 학생 확인 >> 2번 학생 여벌 있음 ㅇㅋ
//    2번 학생 여벌 빌려준 것으로 체크, 참여 가능 줄이지 않음 (참여 가능 8)
//  3번 바보:
//    2번 학생, 4번 학생 확인 >> 여벌 없음 gg
//    참여 가능 1 줄임 (참여 가능 7)
//  4번 바보:
//    3번 학생, 5번 학생 확인 >> 5번 학생 여벌 있음 ㅇㅋ
//    참여 가능 줄이지 않음 (참여 가능 7)
//  6번 바보:
//    참여 가능 줄이지 않음 (참여 가능 7)
//  7번 바보:
//    본인은 여벌 안 가져옴
//    6번 학생, 8번 학생 확인 >> 여벌 없음 gg
//    참여 가능 1 줄임 (참여 가능 6)

import java.util.Arrays;

public class Uniform {
  public int solution(
      int studentNumber, int[] lost, int[] stockedExtra) {
    int studentNumberCanTakeClasses = studentNumber;

    boolean[] lentClothes = new boolean[stockedExtra.length];

    Arrays.fill(lentClothes, false);

    // 여벌을 가져왔는데 바보인 학생이 있는지 확인
    // 있으면 못 빌려주는 상태로 전환
    for (int i = 0; i < lost.length; i += 1) {
      for (int j = 0; j < stockedExtra.length; j += 1) {
        if (lost[i] == stockedExtra[j]) {
          lentClothes[j] = true;
          break;
        }
      }
    }

    for (int studentIndex : lost) {
      boolean canTakeClasses = false;

      for (int i = 0; i < stockedExtra.length; i += 1) {
        // 본인이 여벌을 가져온 바보였으면 어쨌든 본인은 참가 가능
        if (stockedExtra[i] == studentIndex) {
          canTakeClasses = true;
          break;
        }

        // 앞뒤 학생이 여벌이 있는지 확인
        // 여벌이 있으면 참석 가능하고 해당 여벌은 빌린 것으로 처리
        if ((stockedExtra[i] == studentIndex - 1
            || stockedExtra[i] == studentIndex + 1)
            && !lentClothes[i]) {
          lentClothes[i] = true;
          canTakeClasses = true;
          break;
        }
      }

      if (!canTakeClasses) {
        studentNumberCanTakeClasses -= 1;
      }
    }

    return studentNumberCanTakeClasses;
  }
}
