//
// 필요한 변수
//   1. 각 개인이 누굴 신고했는지 기록하는 배열
//   2. 각 개인이 신고당한 횟수를 기록하는 배열
//   3. 정지당한 아이디 배열
//   4. 각 개인에게 날라올 메일 횟수 카운트 배열
// (이때 각 개인의 순서는 1, 2, 4번의 배열이 모두 같아야 함)
//
// 처리 과정
//   1. report의 길이만큼 반복을 돌린다.
//     1-1. 신고 기록을 하나 꺼내온다.
//     1-2. 신고당한 자를 이전에 신고한 기록이 없었다면 누굴 신고했는지 기록하는 배열에
//          신고당한 자의 이름을 기록한다. 이미 신고한 기록이 있다면 무시한다.
//     1-3. 신고당한 사람의 신고당한 카운트를 1 증가시킨다.
//     1-4. 각 개인이 신고당한 카운트가 정지기준 이상이면 정지 리스트에 신고당한 개인의 이름을 추가한다.
//   2. 개인이 누굴 신고했는지 기록한 배열의 길이만큼 반복을 돌린다.
//     2-1. 정지당한 아이디 배열을 확인해 그 개인이 신고한 아이디 중에
//          정지당한 아이디가 있는지 확인한다.
//     2-2. 정지당한 아이디가 있으면 각 개인에게 날라올 메일 횟수 카운트를 1 증가시킨다.

import java.util.ArrayList;
import java.util.List;

public class ReportResults {
  public int[] solution(String[] users, String[] reports, int limit) {
    int numberUsers = users.length;

    // 각 개인이 누굴 신고했는지 기록하는 배열
    List<List<String>> reportingRecords = new ArrayList<>();

    for (int i = 0; i < numberUsers; i += 1) {
      reportingRecords.add(new ArrayList<>());
    }

    // 각 개인이 신고당한 횟수를 기록하는 배열
    int[] reportedCounts = new int[numberUsers];

    for (int i = 0; i < reports.length; i += 1) {
      String[] report = reports[i].split(" ");

      for (int j = 0; j < numberUsers; j += 1) {

      }
    }
  }
}
