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
        test.solution(participants, completions)
    );
  }

  @Test
  void solution2() {
    NotFinishedParticipant test = new NotFinishedParticipant();

    String[] participants = new String[]{"mislav", "stanko", "mislav", "ana"};
    String[] completions = new String[]{"stanko", "ana", "mislav"};

    assertEquals(
        "mislav",
        test.solution(participants, completions)
    );
  }
}
