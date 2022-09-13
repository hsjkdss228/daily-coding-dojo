import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportResult {
  public int[] solution(String[] idList, String[] reports, int limitReportedCount) {
    Map<String, List<String>> reportedCountBoard = makeReportedCountBoard(idList);

    String[] deduplicatedReports = deduplicateReports(reports);

    reportProcess(reportedCountBoard, deduplicatedReports);

    List<String> suspendedAccount = suspendAccount(reportedCountBoard, limitReportedCount);

    return makeCountsEmailToBeSent(idList, suspendedAccount, reportedCountBoard);
  }

  public Map<String, List<String>> makeReportedCountBoard(String[] idList) {
    Map<String, List<String>> reportedCountBoard = new LinkedHashMap<>();

    for (String id : idList) {
      reportedCountBoard.put(id, new ArrayList<>());
    }

    return reportedCountBoard;
  }

  public String[] deduplicateReports(String[] reports) {
    Set<String> deduplicatedReports = Arrays.stream(reports)
        .collect(Collectors.toSet());

    return deduplicatedReports.toArray(String[]::new);
  }

  public void reportProcess(
      Map<String, List<String>> reportedCountBoard, String[] deduplicatedReports) {
    for (String report : deduplicatedReports) {
      String[] reporterAndReportee = report.split(" ");
      String reporter = reporterAndReportee[0];
      String reportee = reporterAndReportee[1];

      reportedCountBoard.get(reportee).add(reporter);
    }
  }

  public List<String> suspendAccount(
      Map<String, List<String>> reportedCountBoard, int limitReportedCount) {
    List<String> suspendedAccount = new ArrayList<>();

    // for문으로 Set의 모든 요소를 순회할 수 있다는 사실은 놀랍다...
    for (String reportee : reportedCountBoard.keySet()) {
      int reportedCount = reportedCountBoard.get(reportee).size();

      if (reportedCount >= limitReportedCount) {
        suspendedAccount.add(reportee);
      }
    }

    return suspendedAccount;
  }

  public int[] makeCountsEmailToBeSent(
      String[] idList, List<String> suspendedAccounts,
      Map<String, List<String>> reportedCountBoard) {
    Map<String, Integer> countsEmailToBeSent = new LinkedHashMap<>();

    for (String id : idList) {
      countsEmailToBeSent.put(id, 0);
    }

    for (String suspendedAccount : suspendedAccounts) {
      List<String> reporters = reportedCountBoard.get(suspendedAccount);

      for (String reporter : reporters) {
        countsEmailToBeSent.replace(reporter, countsEmailToBeSent.get(reporter) + 1);
      }
    }

    return countsEmailToBeSent.values().stream()
        .collect(Collectors.toList())
        .stream().mapToInt(i -> i)
        .toArray();
  }
}
