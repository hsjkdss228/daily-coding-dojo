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
}
