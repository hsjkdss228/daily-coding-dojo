import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindKimTest {
    @Test
    void solution() {
        FindKim test = new FindKim();
        String[] seoul = new String[]{"Eric", "Trump", "Kishida", "Kim", "Ray"};
        assertThat(test.solution(seoul)).isEqualTo("김서방은 3에 있다");
    }
}
