import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class WallpaperTest {
    private Wallpaper test;

    @BeforeEach
    void setUp() {
        test = new Wallpaper();
    }

    @Test
    void solution1() {
        String[] wallpaper = {
            ".#...",
            "..#..",
            "...#."
        };
        assertThat(test.solution(wallpaper)).isEqualTo(new int[]{0, 1, 3, 4});
    }

    @Test
    void solution2() {
        String[] wallpaper = {
            "..........",
            ".....#....",
            "......##..",
            "...##.....",
            "....#....."
        };
        assertThat(test.solution(wallpaper)).isEqualTo(new int[]{1, 3, 5, 8});
    }

    @Test
    void solution3() {
        String[] wallpaper = {
            "#####",
            "#####",
            "#####"
        };
        assertThat(test.solution(wallpaper)).isEqualTo(new int[]{0, 0, 3, 5});
    }

    @Test
    void solution4() {
        String[] wallpaper = {
            ".....",
            ".....",
            "....#"
        };
        assertThat(test.solution(wallpaper)).isEqualTo(new int[]{2, 4, 3, 5});
    }
}
