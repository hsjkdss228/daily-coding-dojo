import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordTest {
//    @Test
//    void cannotCount1() {
//        Password test = new Password();
//
//        char alphabet = 'h';
//        String skip = "holy";
//        assertThat(test.cannotCount(alphabet, skip)).isTrue();
//    }
//
//    @Test
//    void cannotCount2() {
//        Password test = new Password();
//
//        char alphabet = 'h';
//        String skip = "peach";
//        assertThat(test.cannotCount(alphabet, skip)).isTrue();
//    }
//
//    @Test
//    void canCount() {
//        Password test = new Password();
//
//        char alphabet1 = 'h';
//        String skip1 = "abcd";
//        assertThat(test.cannotCount(alphabet1, skip1)).isFalse();
//    }

    @Test
    void createAlphabet1() {
        Password test = new Password();

        char alphabet = 'h';
        String skip = "holy";
        int index = 5;
        assertThat(test.createAlphabet(alphabet, skip, index))
            .isEqualTo('n');
    }

    @Test
    void createAlphabet2() {
        Password test = new Password();

        char alphabet = 'y';
        String skip = "abc";
        int index = 5;
        assertThat(test.createAlphabet(alphabet, skip, index))
            .isEqualTo('g');
    }

    @Test
    void createAlphabet3() {
        Password test = new Password();

        char alphabet = 'a';
        String skip = "xyz";
        int index = 5;
        assertThat(test.createAlphabet(alphabet, skip, index))
            .isEqualTo('f');
    }

    @Test
    void solution() {
        Password test = new Password();

        String string = "aukks";
        String skip = "wbqd";
        int index = 5;
        assertThat(test.solution(string, skip, index))
            .isEqualTo("happy");
    }
}
