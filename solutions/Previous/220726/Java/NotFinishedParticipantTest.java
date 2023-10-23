import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotFinishedParticipantTest {
  @Test
  void solution1() {
    NotFinishedParticipant test = new NotFinishedParticipant();

    String[] participants = new String[]{"leo", "kiki", "eden"};
    String[] completions = new String[]{"eden", "kiki"};

    assertEquals(
        "leo",
        test.solution(participants, completions));

    String[] participants2 = new String[]{"mislav", "stanko", "mislav", "ana"};
    String[] completions2 = new String[]{"stanko", "ana", "mislav"};

    assertEquals(
        "mislav",
        test.solution(participants2, completions2));
  }

  @Test
  void solution2() {
    NotFinishedParticipant test = new NotFinishedParticipant();

    String[] participants = new String[]{"leo", "kiki", "eden"};
    String[] completions = new String[]{"eden", "kiki"};

    assertEquals(
        "leo",
        test.solution2(participants, completions));

    String[] participants2 = new String[]{"mislav", "stanko", "mislav", "ana"};
    String[] completions2 = new String[]{"stanko", "ana", "mislav"};

    assertEquals(
        "mislav",
        test.solution2(participants2, completions2));
  }
}
