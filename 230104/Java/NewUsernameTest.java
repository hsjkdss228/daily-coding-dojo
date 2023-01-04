import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NewUsernameTest {
    private NewUsername test;

    @BeforeEach
    void setUp() {
        test = new NewUsername();
    }

    @Test
    void phase1() {
        String newUsername = "...!@BaT#*..y.abcdefghijklm";
        test.initialize(newUsername);
        test.phase1();
        assertThat(test.words()).isEqualTo("...!@bat#*..y.abcdefghijklm");
    }

    @Test
    void phase2() {
        String newUsername = "...!@bat#*..y.abcdefghijklm";
        test.initialize(newUsername);
        test.phase2();
        assertThat(test.words()).isEqualTo("...bat..y.abcdefghijklm");
    }

    @Test
    void phase3() {
        String newUsername = "...bat..y.abcdefghijklm";
        test.initialize(newUsername);
        test.phase3();
        assertThat(test.words()).isEqualTo(".bat.y.abcdefghijklm");
    }

    @Test
    void phase4() {
        String newUsername = ".bat.y.abcdefghijklm";
        test.initialize(newUsername);
        test.phase4();
        assertThat(test.words()).isEqualTo("bat.y.abcdefghijklm");
    }

    @Test
    void phase5() {
        String newUsername = "bat.y.abcdefghijklm";
        test.initialize(newUsername);
        test.phase5();
        assertThat(test.words()).isEqualTo("bat.y.abcdefghijklm");
    }

    @Test
    void phase6() {
        String newUsername = "bat.y.abcdefgh.jklm";
        test.initialize(newUsername);
        test.phase6();
        assertThat(test.words()).isEqualTo("bat.y.abcdefgh");
    }

    @Test
    void phase7() {
        String newUsername = "a";
        test.initialize(newUsername);
        test.phase7();
        assertThat(test.words()).isEqualTo("aaa");
    }

    @Test
    void solution1() {
        String newUsername = "...!@BaT#*..y.abcdefghijklm";
        assertThat(test.solution(newUsername)).isEqualTo("bat.y.abcdefghi");
    }

    @Test
    void solution2() {
        String newUsername = "z-+.^.";
        assertThat(test.solution(newUsername)).isEqualTo("z--");
    }

    @Test
    void solution3() {
        String newUsername = "=.=";
        assertThat(test.solution(newUsername)).isEqualTo("aaa");
    }
}
