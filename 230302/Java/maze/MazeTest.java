import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MazeTest {
    private Maze test;

    @BeforeEach
    void setUp() {
        test = new Maze();
    }

    @Test
    void createIndexVisitCountMap() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        int[][] indexVisitCountMap = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        assertThat(test.createIndexVisitCountMap(map))
            .isEqualTo(indexVisitCountMap);
    }

    @Test
    void solution1() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        assertThat(test.solution(map)).isEqualTo(16);
    }

    @Test
    void solution2() {
        String[] map = {
            "LOOXS",
            "OOOOX",
            "OOOOO",
            "OOOOO",
            "EOOOO"
        };
        assertThat(test.solution(map)).isEqualTo(-1);
    }

    @Test
    void isValidIndex1() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        Maze.Index index = Maze.Index.of(0, 0);
        assertThat(test.isInvalidIndex(map, index)).isFalse();
    }

    @Test
    void isValidIndex2() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        Maze.Index index = Maze.Index.of(4, 0);
        assertThat(test.isInvalidIndex(map, index)).isFalse();
    }

    @Test
    void isValidIndex3() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        Maze.Index index = Maze.Index.of(0, 4);
        assertThat(test.isInvalidIndex(map, index)).isFalse();
    }

    @Test
    void isValidIndex4() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        Maze.Index index = Maze.Index.of(4, 4);
        assertThat(test.isInvalidIndex(map, index)).isFalse();
    }

    @Test
    void outOfRangeUpward() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        Maze.Index index = Maze.Index.of(-1, 0);
        assertThat(test.isInvalidIndex(map, index)).isTrue();
    }

    @Test
    void outOfRangeDownward() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        Maze.Index index = Maze.Index.of(5, 0);
        assertThat(test.isInvalidIndex(map, index)).isTrue();
    }

    @Test
    void outOfRangeToTheLeft() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        Maze.Index index = Maze.Index.of(0, -1);
        assertThat(test.isInvalidIndex(map, index)).isTrue();
    }

    @Test
    void outOfRangeToTheRight() {
        String[] map = {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        };
        Maze.Index index = Maze.Index.of(0, 5);
        assertThat(test.isInvalidIndex(map, index)).isTrue();
    }

    @Test
    void solution3() {
        String[] map = {
            "SOXXX",
            "XOXLX",
            "OOOOO",
            "OXOXX",
            "XXOOE"
        };
        assertThat(test.solution(map)).isEqualTo(12);
    }

    @Test
    void solution4() {
        String[] map = {
            "SOOOL",
            "OOOOE"
        };
        assertThat(test.solution(map)).isEqualTo(5);
    }

    @Test
    void solution5() {
        String[] map = {
            "OXXXE",
            "SOLXO",
            "XOXXO",
            "OOOOO"
        };
        assertThat(test.solution(map)).isEqualTo(11);
    }
}
