import java.util.ArrayList;
import java.util.List;

public class TrialExam {
  private int[][] submittedAnswers;

  public int[] submittedAnswer1() {
    return submittedAnswers[0];
  }

  public int[] submittedAnswer2() {
    return submittedAnswers[1];
  }

  public int[] submittedAnswer3() {
    return submittedAnswers[2];
  }

  public int[] solution(int[] answers) {
    makeSubmittedAnswers(answers.length);

    return checkRanking(answers);
  }

  public void makeSubmittedAnswers(int length) {
    submittedAnswers = new int[3][length];

    for (int i = 0; i < length; i += 1) {
      int index = i + 1;

      submittedAnswers[0][i] =
          (index % 5 == 0)
              ? 5
              : (index % 5);

      submittedAnswers[1][i] = switch (index % 2) {
        case 1 -> 2;
        case 0 -> switch (index % 8) {
          case 2 -> 1;
          case 4 -> 3;
          case 6 -> 4;
          case 0 -> 5;
          default -> 0;
        };
        default -> 0;
      };

      submittedAnswers[2][i] = switch (index % 10) {
        case 1, 2 -> 3;
        case 3, 4 -> 1;
        case 5, 6 -> 2;
        case 7, 8 -> 4;
        case 9, 0 -> 5;
        default -> 0;
      };

//      System.out.println("submittedAnswers[0][i]: " + submittedAnswers[0][i]);
//      System.out.println("submittedAnswers[1][i]: " + submittedAnswers[1][i]);
//      System.out.println("submittedAnswers[2][i]: " + submittedAnswers[2][i]);
    }
  }

  public int[] checkRanking(int[] answers) {
    int[] answerCounts = new int[3];

    for (int i = 0; i < answers.length; i += 1) {
      for (int studentIndex = 0; studentIndex <= 2; studentIndex += 1) {
        if (answers[i] == submittedAnswers[studentIndex][i]) {
          answerCounts[studentIndex] += 1;
        }
      }
    }

    List<Integer> ranking = new ArrayList<>();

    int bigger = Math.max(answerCounts[0], answerCounts[1]);
    int biggest = Math.max(bigger, answerCounts[2]);

    for (int i = 0; i <= 2; i += 1) {
      if (answerCounts[i] == biggest) {
        ranking.add(i + 1);
      }
    }

    return ranking.stream()
        .mapToInt(i -> i)
        .toArray();
  }

  // 1. 문제 개수만큼 수포자들의 답안을 만든다.
  // 2. 수포자들의 답안 배열과 답지 배열을 처음부터 하나씩 비교한다.
  //    각 수포자가 정답을 맞춘 개수를 일단 기록한다.
  // 3. 최종적으로 정답을 맞춘 개수를 비교해 정답 배열을 만든다.

  public int[] solution2(int[] answers) {
    int[][] madeAnswers = makeAnswers(answers.length);

    int[] correctAnswers = checkAnswers(madeAnswers, answers);

    return rank(correctAnswers);
  }

  public int[][] makeAnswers(int numberOfAnswer) {
    int[] answerRuleStudent1 = new int[]{1, 2, 3, 4, 5};
    int[] answerRuleStudent2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    int[] answerRuleStudent3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int[][] answers = new int[3][numberOfAnswer];

    for (int i = 0; i < numberOfAnswer; i += 1) {
      int answerRuleLengthStudent1 = answerRuleStudent1.length;
      int answerRuleLengthStudent2 = answerRuleStudent2.length;
      int answerRuleLengthStudent3 = answerRuleStudent3.length;

      answers[0][i] = answerRuleStudent1[i % answerRuleLengthStudent1];
      answers[1][i] = answerRuleStudent2[i % answerRuleLengthStudent2];
      answers[2][i] = answerRuleStudent3[i % answerRuleLengthStudent3];
    }

    return answers;
  }

  public int[] checkAnswers(int[][] madeAnswers, int[] answers) {
    int[] correctAnswers = new int[]{0, 0, 0};

    for (int i = 0; i < madeAnswers.length; i += 1) {
      for (int j = 0; j < madeAnswers[i].length; j += 1) {
        if (madeAnswers[i][j] == answers[j]) {
          correctAnswers[i] += 1;
        }
      }
    }

    return correctAnswers;
  }

  public int[] rank(int[] correctAnswers) {
    List<Integer> ranking = new ArrayList<>();

    int higher = Math.max(correctAnswers[0], correctAnswers[1]);
    int highest = Math.max(higher, correctAnswers[2]);

    for (int i = 0; i < correctAnswers.length; i += 1) {
      if (correctAnswers[i] == highest) {
        ranking.add(i + 1);
      }
    }

    return ranking.stream()
        .mapToInt(element -> element)
        .toArray();
  }
}
