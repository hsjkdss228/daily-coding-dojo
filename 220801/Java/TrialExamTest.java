import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrialExamTest {
  //
  // 문제풀이 1
  //
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

  //
  // 문제풀이 2
  //
  @Test
  void makeAnswers() {
    TrialExam test = new TrialExam();

    int[][] madeAnswers = test.makeAnswers(15);

    assertArrayEquals(madeAnswers[0],
        new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5});
    assertArrayEquals(madeAnswers[1],
        new int[]{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2});
    assertArrayEquals(madeAnswers[2],
        new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2});
  }

  @Test
  void checkAnswers() {
    TrialExam test = new TrialExam();

    int[][] madeAnswers = new int[][]{
        {1, 2, 3, 4, 5, 1, 2},
        {2, 1, 2, 3, 2, 4, 2},
        {3, 3, 1, 1, 2, 2, 4}
    };
    int[] answers = new int[]{3, 1, 4, 5, 2, 5, 3};

    int[] correctAnswers = test.checkAnswers(madeAnswers, answers);

    assertArrayEquals(correctAnswers, new int[]{0, 2, 2});
  }

  @Test
  void rank() {
    TrialExam test = new TrialExam();

    int[] correctAnswers1 = new int[]{0, 2, 2};
    int[] ranking1 = test.rank(correctAnswers1);
    assertArrayEquals(ranking1, new int[]{2, 3});

    int[] correctAnswers2 = new int[]{5, 1, 3};
    int[] ranking2 = test.rank(correctAnswers2);
    assertArrayEquals(ranking2, new int[]{1});

    int[] correctAnswers3 = new int[]{4, 4, 4};
    int[] ranking3 = test.rank(correctAnswers3);
    assertArrayEquals(ranking3, new int[]{1, 2, 3});
  }
}
