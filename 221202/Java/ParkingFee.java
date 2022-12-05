import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParkingFee {
    public int[] solution(int[] fees, String[] records) {
        int INF = 23 * 60 + 59;
        Map<Integer, Integer> startTime = new HashMap<>();
        Map<Integer, Integer> totalTime = new HashMap<>();
        Set<Integer> carSet = new HashSet<>();

        for (String record : records) {
            String[] string = record.split(" ");
            String[] times = string[0].split(":");
            int minute = (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
            int number = Integer.parseInt(string[1]);

            if (!startTime.containsKey(number)) {
                carSet.add(number);
                startTime.put(number, minute);
                if (!totalTime.containsKey(number)) {
                    totalTime.put(number, 0);
                }
                continue;
            }

            if (startTime.containsKey(number)) {
                totalTime.put(number, totalTime.get(number) + minute - startTime.get(number));
                startTime.remove(number);
            }
        }

        for (Integer key : startTime.keySet()) {
            totalTime.put(key, totalTime.get(key) + INF - startTime.get(key));
        }

        List<Integer> list = new ArrayList<>(carSet);
        Collections.sort(list);
        int[] answer = new int[carSet.size()];
        int index = 0;
        for (int number : list) {
            int time = totalTime.get(number);
            if (time <= fees[0]) {
                answer[index] = fees[1];
            }
            if (time > fees[0]) {
                answer[index] = (int) (fees[1] + Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3]);
            }
            index += 1;
        }

        return answer;
    }
}
