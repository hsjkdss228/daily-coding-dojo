import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Maze {
    public static class Index {
        private final int x;
        private final int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Index of(int x, int y) {
            return new Index(x, y);
        }

        public static Index error() {
            return new Index(-1, -1);
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
    }

    public enum PreviousDirection {
        NO_PREVIOUS_DIRECTION,
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public int solution(String[] map) {
        Index startIndex = findIndex(map, 'S');
        int[][] indexVisitCountMap = createIndexVisitCountMap(map);
        Set<Integer> timesStartToLever = new HashSet<>();
        Set<Character> movableTypesExpectLever = Set.of(
            'O', 'S', 'E'
        );
        findPath(
            map,
            indexVisitCountMap,
            startIndex,
            'L',
            movableTypesExpectLever,
            PreviousDirection.NO_PREVIOUS_DIRECTION,
            timesStartToLever,
            0
        );
        int minimumTimeStartToLever = timesStartToLever.stream()
            .mapToInt(time -> time)
            .min()
            .orElse(-1);

        if (minimumTimeStartToLever == -1) {
            return -1;
        }

        System.out.println();

        Index leverIndex = findIndex(map, 'L');
        indexVisitCountMap = createIndexVisitCountMap(map);
        Set<Integer> timesLeverToExit = new HashSet<>();
        Set<Character> movableTypesExpectExit = Set.of(
            'O', 'S', 'L'
        );
        findPath(
            map,
            indexVisitCountMap,
            leverIndex,
            'E',
            movableTypesExpectExit,
            PreviousDirection.NO_PREVIOUS_DIRECTION,
            timesLeverToExit,
            0
        );
        int minimumTimeLeverToExit = timesLeverToExit.stream()
            .mapToInt(time -> time)
            .min()
            .orElse(-1);

        if (minimumTimeLeverToExit == -1) {
            return -1;
        }

        return minimumTimeStartToLever + minimumTimeLeverToExit;
    }

    public Index findIndex(String[] map, char targetType) {
        for (int i = 0; i < map.length; i += 1) {
            for (int j = 0; j < map[i].length(); j += 1) {
                char type = map[i].charAt(j);
                if (type == targetType) {
                    return Index.of(i, j);
                }
            }
        }
        return Index.error();
    }

    public int[][] createIndexVisitCountMap(String[] map) {
        int[][] indexVisitCountMap = new int[map.length][];
        for (int i = 0; i < map.length; i += 1) {
            indexVisitCountMap[i] = new int[map[i].length()];
        }
        return indexVisitCountMap;
    }

    public void findPath(String[] map,
                         int[][] indexVisitCountMap,
                         Index currentIndex,
                         char destinationType,
                         Set<Character> movableTypes,
                         PreviousDirection previousDirection,
                         Set<Integer> timesStartToDestination,
                         int currentTime) {
        if (isInvalidIndex(map, currentIndex)
            || indexVisitCountMap[currentIndex.x()][currentIndex.y()] >= 1) {
            return;
        }

        System.out.println("currentIndex: x=" + currentIndex.x() + ", y=" + currentIndex.y());

        char type = map[currentIndex.x()].charAt(currentIndex.y());
        if (type == 'X') {
            return;
        }
        if (type == destinationType) {
            timesStartToDestination.add(currentTime);
            return;
        }
        if (movableTypes.contains(type)) {
            indexVisitCountMap[currentIndex.x()][currentIndex.y()] = 1;
            if (previousDirection != PreviousDirection.DOWN) {
                findPath(
                    map,
                    indexVisitCountMap,
                    Index.of(currentIndex.x() + 1, currentIndex.y()),
                    destinationType,
                    movableTypes,
                    PreviousDirection.UP,
                    timesStartToDestination,
                    currentTime + 1
                );
            }
            if (previousDirection != PreviousDirection.UP) {
                findPath(
                    map,
                    indexVisitCountMap,
                    Index.of(currentIndex.x() - 1, currentIndex.y()),
                    destinationType,
                    movableTypes,
                    PreviousDirection.DOWN,
                    timesStartToDestination,
                    currentTime + 1
                );
            }
            if (previousDirection != PreviousDirection.RIGHT) {
                findPath(
                    map,
                    indexVisitCountMap,
                    Index.of(currentIndex.x(), currentIndex.y() + 1),
                    destinationType,
                    movableTypes,
                    PreviousDirection.LEFT,
                    timesStartToDestination,
                    currentTime + 1
                );
            }
            if (previousDirection != PreviousDirection.LEFT) {
                findPath(
                    map,
                    indexVisitCountMap,
                    Index.of(currentIndex.x(), currentIndex.y() - 1),
                    destinationType,
                    movableTypes,
                    PreviousDirection.RIGHT,
                    timesStartToDestination,
                    currentTime + 1
                );
            }
        }
    }

    public boolean isInvalidIndex(String[] map, Index currentIndex) {
        return currentIndex.x() < 0
            || currentIndex.y() < 0
            || currentIndex.x() >= map.length
            || currentIndex.y() >= map[0].length();
    }

    public void resetIndexVisitCountMap(int[][] indexVisitCountMap) {
        for (int[] rows : indexVisitCountMap) {
            Arrays.fill(rows, 0);
        }
    }
}
