import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReportResultTest {
  @Test
  void makeReportedCountBoard() {
    ReportResult test = new ReportResult();

    String[] idList = new String[]{"muzi", "frodo", "apeach", "neo"};

    Map<String, List<String>> reportCountBoard
        = test.makeReportedCountBoard(idList);

    assertEquals(4, reportCountBoard.size());
    assertNotNull(reportCountBoard.get("muzi"));
    assertNotNull(reportCountBoard.get("frodo"));
    assertNotNull(reportCountBoard.get("apeach"));
    assertNotNull(reportCountBoard.get("neo"));
  }

  @Test
  void deduplicateReportsWithNoDuplication() {
    ReportResult test = new ReportResult();

    String[] reports = new String[]{
        "muzi frodo",
        "apeach frodo",
        "frodo neo",
        "muzi neo",
        "apeach muzi"
    };

    String[] deduplicatedReports = test.deduplicateReports(reports);

    assertEquals(5, deduplicatedReports.length);
  }

  @Test
  void deduplicateReportsWithDuplications() {
    ReportResult test = new ReportResult();

    String[] reports = new String[]{
        "muzi neo",
        "muzi frodo",
        "muzi frodo",
        "muzi frodo",
        "apeach muzi"
    };

    String[] deduplicatedReports = test.deduplicateReports(reports);

    assertEquals(3, deduplicatedReports.length);
  }

  @Test
  void reportProcess() {
    ReportResult test = new ReportResult();

    Map<String, List<String>> reportedCountBoard = Map.of(
        "muzi", new ArrayList<>(),
        "frodo", new ArrayList<>(),
        "apeach", new ArrayList<>(),
        "neo", new ArrayList<>()
    );

    String[] reports = new String[]{
        "muzi frodo",
        "apeach frodo",
        "frodo neo",
        "muzi neo",
        "apeach muzi",
        "apeach neo",
    };

    test.reportProcess(reportedCountBoard, reports);

    assertEquals(3, reportedCountBoard.get("neo").size());
    assertEquals(2, reportedCountBoard.get("frodo").size());
    assertEquals(1, reportedCountBoard.get("muzi").size());
    assertEquals(0, reportedCountBoard.get("apeach").size());
  }

  @Test
  void suspendAccount() {
    ReportResult test = new ReportResult();

    Map<String, List<String>> reportedCountBoard = Map.of(
        "muzi", List.of("apeach"),
        "frodo", List.of("muzi", "apeach"),
        "apeach", List.of(),
        "neo", List.of("frodo", "muzi", "apeach")
    );

    int limitReportedCount = 2;

    List<String> suspendedAccounts
        = test.suspendAccount(reportedCountBoard, limitReportedCount);

    assertTrue(suspendedAccounts.contains("frodo"));
    assertTrue(suspendedAccounts.contains("neo"));
  }

  @Test
  void makeCountsEmailToBeSent() {
    ReportResult test = new ReportResult();

    String[] idList = new String[]{"muzi", "frodo", "apeach", "neo"};

    Map<String, List<String>> reportedCountBoard = Map.of(
        "muzi", List.of("apeach"),
        "frodo", List.of("muzi", "apeach"),
        "apeach", List.of(),
        "neo", List.of("frodo", "muzi", "apeach")
    );

    List<String> suspendedAccounts = List.of("frodo", "neo");

    int[] countsEmailToBeSent
        = test.makeCountsEmailToBeSent(
            idList, suspendedAccounts, reportedCountBoard);

    assertArrayEquals(new int[]{2, 1, 2, 0}, countsEmailToBeSent);
  }
}