import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ExpirationDateTest {
    @Test
    void parseDate() {
        ExpirationDate test = new ExpirationDate();
        assertThat(test.parseDate("2022.05.19")).isEqualTo(679392 + 140 + 19);
    }

    @Test
    void convertToMap() {
        ExpirationDate test = new ExpirationDate();
        String[] terms = new String[]{"A 6", "B 12", "C 3"};
        assertThat(test.convertToMap(terms)).isEqualTo(Map.of(
            "A", 6 * 28,
            "B", 12 * 28,
            "C", 3 * 28
        ));
    }

    @Test
    void isExpired() {
        ExpirationDate test = new ExpirationDate();
        int todayAbsoluteDate = (2022 * 12 * 28) + (5 * 28) + 19;
        Map<String, Integer> termsTypeAndAbsoluteDate = Map.of(
            "A", 6 * 28,
            "B", 12 * 28,
            "C", 3 * 28
        );

        String term1 = "2021.05.02 A";
        assertThat(test.isExpired(
            term1,
            todayAbsoluteDate,
            termsTypeAndAbsoluteDate))
            .isTrue();

        String term2 = "2021.07.01 B";
        assertThat(test.isExpired(
            term2,
            todayAbsoluteDate,
            termsTypeAndAbsoluteDate))
            .isFalse();

        String term3 = "2022.02.19 C";
        assertThat(test.isExpired(
            term3,
            todayAbsoluteDate,
            termsTypeAndAbsoluteDate))
            .isTrue();
    }

    @Test
    void solution1() {
        ExpirationDate test = new ExpirationDate();
        String today = "2022.05.19";
        String[] terms = new String[]{"A 6", "B 12", "C 3"};
        String[] privacies = new String[]{
            "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"
        };
        assertThat(test.solution(today, terms, privacies))
            .isEqualTo(new int[]{1, 3});
    }

    @Test
    void solution2() {
        ExpirationDate test = new ExpirationDate();
        String today = "2020.01.01";
        String[] terms = new String[]{"Z 3", "D 5"};
        String[] privacies = new String[]{
            "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"
        };
        assertThat(test.solution(today, terms, privacies))
            .isEqualTo(new int[]{1, 4, 5});
    }
}