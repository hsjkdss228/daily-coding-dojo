// 실패율
// : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
//   (스테이지에 도달한 플레이어의 수가 없을 경우 해당 스테이지의 실패율은 0)
//
// totalStages
// : 전체 스테이지의 개수
//   (1 이상 500 이하의 자연수)
//
// stagesEachUserIsChallenging
// : 게임을 이용하는 각 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
//   (배열의 길이는 1 이상 200000 이하)
//   (배열의 각 요소는 1 이상 TotalStages + 1 이하의 자연수)
//   (TotalStages + 1인 경우 마지막 스테이지까지 클리어한 것)
//
// answer
// : 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
//   (실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 함)

public class FailureRate {
  public int[] solution(int totalStages, int[] stagesEachUserChallenging) {
    int[] stageIndices = new int[totalStages];
    double[] failureRateOfStages = new double[totalStages];

    for (int stageIndex = 1; stageIndex <= totalStages; stageIndex += 1) {
      double numberOfUsersReachedThatStage = 0;
      double numberOfUsersChallengingThatStage = 0;

      for (int stageEachUserChallenging : stagesEachUserChallenging) {
        if (stageEachUserChallenging >= stageIndex) {
          numberOfUsersReachedThatStage += 1;
        }

        if (stageEachUserChallenging == stageIndex) {
          numberOfUsersChallengingThatStage += 1;
        }
      }

      double failureRate = 0;

      if (numberOfUsersReachedThatStage > 0) {
        failureRate
            = numberOfUsersChallengingThatStage / numberOfUsersReachedThatStage;
      }

      /*System.out.println("현재 스테이지: " + stageIndex
          + ", 스테이지 실패율: " + failureRate);*/

      stageIndices[stageIndex - 1] = stageIndex;
      failureRateOfStages[stageIndex - 1] = failureRate;
    }

    //정렬
    for (int i = 0; i < totalStages; i += 1) {
      for (int j = 0; j < totalStages - i; j += 1) {
        if (j + 1 != totalStages
            && failureRateOfStages[j] < failureRateOfStages[j + 1]) {
          double tempForFailureRate = failureRateOfStages[j + 1];
          failureRateOfStages[j + 1] = failureRateOfStages[j];
          failureRateOfStages[j] = tempForFailureRate;

          int tempForStageIndex = stageIndices[j + 1];
          stageIndices[j + 1] = stageIndices[j];
          stageIndices[j] = tempForStageIndex;
        }
      }
    }

    return stageIndices;
  }
}
