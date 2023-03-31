import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Billiard {
    public enum StandardAxis {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM;
    }

    public int[] solution(int width, int height,
                          int startX, int startY,
                          int[][] balls) {
        return Arrays.stream(balls)
            .map(ballPosition -> {
                int endX = ballPosition[0];
                int endY = ballPosition[1];
                Map<StandardAxis, Integer> axisAndDistances
                    = calculateDistances(
                    height, width, startX, startY, endX, endY
                );
                return findMinimumDistance(axisAndDistances);
            })
            .mapToInt(answer -> answer)
            .toArray();
    }

    public Map<StandardAxis, Integer> calculateDistances(int height, int width,
                                                         int startX, int startY,
                                                         int endX, int endY) {
        Map<StandardAxis, Integer> axisAndDistances = new HashMap<>();
        List.of(
            StandardAxis.LEFT,
            StandardAxis.RIGHT,
            StandardAxis.TOP,
            StandardAxis.BOTTOM
        ).forEach(standardAxis -> {
            if (notToBeFlipped(startX, startY, endX, endY, standardAxis)) {
                return;
            }
            int[] flippedEndPoint = flip(
                height, width, endX, endY, standardAxis
            );
            int flippedEndX = flippedEndPoint[0];
            int flippedEndY = flippedEndPoint[1];
            int distance = calculateDistance(
                startX, startY, flippedEndX, flippedEndY
            );
            axisAndDistances.put(standardAxis, distance);
        });
        return axisAndDistances;
    }

    public boolean notToBeFlipped(int startX, int startY,
                                  int endX, int endY,
                                  StandardAxis standardAxis) {
        return (standardAxis.equals(StandardAxis.TOP) && (startX == endX && startY < endY))
            || (standardAxis.equals(StandardAxis.BOTTOM) && (startX == endX && startY > endY))
            || (standardAxis.equals(StandardAxis.LEFT) && (startY == endY && startX > endX))
            || (standardAxis.equals(StandardAxis.RIGHT) && (startY == endY && startX < endX));
    }

    public int findMinimumDistance(Map<StandardAxis, Integer> axisAndDistances) {
        return axisAndDistances.entrySet().stream()
            .reduce((previous, next) -> {
                int previousDistance = previous.getValue();
                int nextDistance = next.getValue();
                return previousDistance < nextDistance ? previous : next;
            })
            .get()
            .getValue();
    }

    public int[] flip(int height, int width,
                      int endX, int endY,
                      StandardAxis standardAxis) {
        return switch (standardAxis) {
            case LEFT -> new int[]{endX * -1, endY};
            case RIGHT -> new int[]{width + (width - endX), endY};
            case TOP -> new int[]{endX, height + (height - endY)};
            case BOTTOM -> new int[]{endX, endY * -1};
        };
    }

    public int calculateDistance(int startX, int startY,
                                 int flippedEndX, int flippedEndY) {
        return (int) (
            Math.pow(startX - flippedEndX, 2) + Math.pow(startY - flippedEndY, 2)
        );
    }
}
