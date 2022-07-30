import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotFinishedParticipant {
  public String solution(String[] participants, String[] finishers) {
    Map<String, List<Boolean>> finishRecords = new HashMap<>();

    // 완주 기록 초기화
    for (String finisher : finishers) {
      // 동명이인이 아니라면
      if (!finishRecords.containsKey(finisher)) {
        List<Boolean> isFinished = new ArrayList<>();
        isFinished.add(true);

        finishRecords.put(finisher, isFinished);
        continue;
      }

      // 동명이인이라면
      finishRecords.get(finisher).add(true);
    }

    String notFinishedParticipant = "";

    // 완주하지 못한 선수 탐색
    for (String participant : participants) {
      // 완주 기록에 이름이 없거나
      // 완주하지 못한 동명이인이라면 정답
      if (!finishRecords.containsKey(participant)
          || finishRecords.get(participant).isEmpty()) {
        notFinishedParticipant = participant;
        break;
      }

      // 동명이인이 있을 수 있으므로 자신의 기록을 삭제
      finishRecords.get(participant).remove(0);
    }

    return notFinishedParticipant;
  }
}
