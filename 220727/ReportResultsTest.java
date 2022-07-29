import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportResultsTest {
  @Test
  void initVariables() {
    ReportResults test = new ReportResults();

    test.initVariables(new String[]{"muzi", "frodo", "apeach", "neo"});

    assertEquals(4, test.reportingRecords().size());
    assertEquals(4, test.reportedCounts().size());
  }

  @Test
  void processReports() {
    ReportResults test = new ReportResults();

    test.initVariables(new String[]{"muzi", "frodo", "apeach", "neo"});

    test.processReports(
        new String[]{
            "muzi frodo",
            "apeach frodo",
            "muzi frodo",
            "muzi frodo",
            "frodo neo",
            "muzi neo",
            "apeach muzi"},
        2
    );

    assertEquals("frodo", test.reportingRecords().get("muzi").get(0));
    assertEquals("neo", test.reportingRecords().get("muzi").get(1));

    assertEquals(2, test.reportedCounts().get("frodo"));

    assertTrue(test.isSuspended().get("frodo"));
    assertFalse(test.isSuspended().get("muzi"));
  }

  @Test
  void countResultMailsToSend() {
    ReportResults test = new ReportResults();

    test.initVariables(new String[]{"muzi", "frodo", "apeach", "neo"});

    test.processReports(
        new String[]{
            "muzi frodo",
            "apeach frodo",
            "muzi frodo",
            "muzi frodo",
            "frodo neo",
            "muzi neo",
            "apeach muzi"},
        2
    );

    assertArrayEquals(
        new int[]{2, 1, 1, 0},
        test.countResultMailsToSend(
            new String[]{"muzi", "frodo", "apeach", "neo"}
        )
    );
  }
}
