import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrialExamTest {
  @Test
  void makeSubmittedAnswers() {
    TrialExam test = new TrialExam();

    test.makeSubmittedAnswers(20);

    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5},
        test.submittedAnswer1()
    );
    assertArrayEquals(
        new int[]{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3},
        test.submittedAnswer2()
    );
    assertArrayEquals(
        new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
        test.submittedAnswer3()
    );
  }

  @Test
  void checkRanking() {
    TrialExam test = new TrialExam();

    test.makeSubmittedAnswers(5);

    assertArrayEquals(new int[]{1, 2, 3}, test.checkRanking(new int[]{1, 3, 2, 4, 2}));
  }
}
