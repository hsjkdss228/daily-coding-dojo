import java.util.ArrayList;
import java.util.List;

public class DevelopPeriod {
    public int[] solution(int[] progressesInitial, int[] speedsInitial) {
        List<Integer> progresses = new ArrayList<>();
        List<Integer> speeds = new ArrayList<>();

        for (int i = 0; i < progressesInitial.length; i += 1) {
            progresses.add(progressesInitial[i]);
            speeds.add(speedsInitial[i]);
        }

        List<Integer> deployCounts = new ArrayList<>();

        while (!progresses.isEmpty()) {
            int deployCount = 0;

            for (int i = 0; i < progresses.size(); i += 1) {
                progresses.set(i, progresses.get(i) + speeds.get(i));
            }

            while (!progresses.isEmpty() && progresses.get(0) >= 100) {
                progresses.remove(0);
                speeds.remove(0);
                deployCount += 1;
            }

            if (deployCount >= 1) {
                deployCounts.add(deployCount);
            }
        }

        return deployCounts.stream()
            .mapToInt(value -> value)
            .toArray();
    }
}
