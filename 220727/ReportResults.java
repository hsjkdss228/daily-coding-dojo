// 필요한 변수
//   1. 각 개인이 누굴 신고했는지 기록하는 맵
//   2. 각 개인이 신고당한 횟수를 기록하는 맵
//   3. 각 개인이 정지당했는지 확인하는 맵
//   4. 각 개인에게 날라올 메일 횟수 카운트 배열
// (이때 각 개인의 순서는 모두 같아야 함 >> 데이터 입력 순서가 지켜지는 LinkedHashMap 사용)
//
// 처리 과정
//   1. 신고 기록에 따른 정지 여부를 처리한다.
//     1-1. report의 길이만큼 반복을 돌린다.
//     1-2. 신고 기록을 하나 꺼내온다.
//     1-3. 신고당한 자를 이전에 신고한 기록이 없었다면
//          누굴 신고했는지 기록하는 맵에 신고당한 자의 이름을 기록한다.
//          이미 신고한 기록이 있다면 무시한다.
//     1-4. 신고당한 사람의 신고당한 카운트를 1 증가시킨다.
//     1-5. 각 개인이 신고당한 카운트가 정지 기준 이상이면
//          개인 정지 여부 확인 맵의 Flag를 정지된 것으로 변경한다.
//   2. 정지 여부를 바탕으로 신고자가 받을 메일 횟수를 기록한다.
//     2-1. 각 개인이 누굴 신고했는지 기록한 맵을 확인한다.
//     2-2. 정지당한 아이디 맵을 확인해
//          그 개인이 신고한 아이디가 정지당했는지 확인한다.
//     2-3. 신고한 아이디가 정지당했으면 그 개인에게 날라올 메일 횟수 카운트를 1 증가시킨다.

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReportResults {
  // 각 개인이 누굴 신고했는지 기록하는 맵
  private Map<String, List<String>> reportingRecords;

  // 각 개인이 신고당한 횟수를 기록하는 맵
  private Map<String, Integer> reportedCounts;

  // 각 개인이 정지당했는지 확인하는 맵
  private Map<String, Boolean> isSuspended;

  public Map<String, List<String>> reportingRecords() {
    return new LinkedHashMap<>(reportingRecords);
  }

  public Map<String, Integer> reportedCounts() {
    return new LinkedHashMap<>(reportedCounts);
  }

  public Map<String, Boolean> isSuspended() {
    return new LinkedHashMap<>(isSuspended);
  }
  
  public int[] solution(String[] users, String[] reports, int limit) {
    initVariables(users);

    processReports(reports, limit);

    return countResultMailsToSend(users);
  }

  public void initVariables(String[] users) {
    reportingRecords = new LinkedHashMap<>();
    reportedCounts = new LinkedHashMap<>();
    isSuspended = new LinkedHashMap<>();

    for (String user : users) {
      reportingRecords.put(user, new ArrayList<>());
      reportedCounts.put(user, 0);
      isSuspended.put(user, false);
    }
  }

  public void processReports(String[] reports, int limit) {
    for (String report : reports) {
      String[] reportRecord = report.split(" ");

      String reportingUser = reportRecord[0];
      String reportedUser = reportRecord[1];

      if (reportingRecords.get(reportingUser).contains(reportedUser)) {
        continue;
      }

      reportingRecords.get(reportingUser).add(reportedUser);

      reportedCounts.replace(
          reportedUser, reportedCounts.get(reportedUser) + 1
      );

      if (reportedCounts.get(reportedUser) >= limit) {
        isSuspended.replace(reportedUser, true);
      }
    }
  }

  public int[] countResultMailsToSend(String[] users) {
    int[] mailCountsToBeReplied = new int[users.length];

    for (int i = 0; i < users.length; i += 1) {
      List<String> reportingRecord = reportingRecords.get(users[i]);

      for (String reportedUser : reportingRecord) {
        if (isSuspended.get(reportedUser)) {
          mailCountsToBeReplied[i] += 1;
        }
      }
    }

    return mailCountsToBeReplied;
  }
}
