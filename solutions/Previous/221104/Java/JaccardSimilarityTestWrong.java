import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class JaccardSimilarityTest {
  @Test
  void toUpperCase() {
    JaccardSimilarity test = new JaccardSimilarity();

    assertThat(test.toUpperCase("abcdEFg")).isEqualTo("ABCDEFG");
  }

  @Test
  void deleteNonAlphabeticalCharacters() {
    JaccardSimilarity test = new JaccardSimilarity();

    assertThat(test.deleteNonAlphabeticalCharacters("ABCDE23%^FGHI"))
        .isEqualTo("ABCDGHI");
  }

  @Test
  void makeMap() {
    JaccardSimilarity test = new JaccardSimilarity();

    Map<String, Integer> multiples = test.makeMap("FRANANCE");
    assertThat(multiples.size()).isEqualTo(6);    // Map의 size는 Key의 개수로 따진다??!
    assertThat(multiples.get("AN")).isEqualTo(2);
  }

  @Test
  void calculateIntersectionCount() {
    JaccardSimilarity test = new JaccardSimilarity();

    Map<String, Integer> multiples1 = test.makeMap("FRANANCE");
    Map<String, Integer> multiples2 = test.makeMap("FRENCH");

    assertThat(
        test.calculateIntersectionCount(multiples1, multiples2))
        .isEqualTo(2);
  }

  @Test
  void calculateUnionCount() {
    JaccardSimilarity test = new JaccardSimilarity();

    Map<String, Integer> multiples1 = test.makeMap("FRANANCE");
    Map<String, Integer> multiples2 = test.makeMap("FRENCH");

    assertThat(
        test.calculateUnionCount(multiples1, multiples2))
        .isEqualTo(10);
  }

  @Test
  void jaccardSimilarity() {
    JaccardSimilarity test = new JaccardSimilarity();

    double intersectionCount = 2;
    double unionCount = 10;
    assertThat(
        test.jaccardSimilarity(intersectionCount, unionCount))
        .isEqualTo(13107);
  }

  @Test
  void solution() {
    JaccardSimilarity test = new JaccardSimilarity();

    assertThat(test.solution("FRANCE", "french")).isEqualTo(16384);
    assertThat(test.solution("handshake", "shake hands")).isEqualTo(65536);
    assertThat(test.solution("aa1+aa2", "AAAA12")).isEqualTo(43690);
    assertThat(test.solution("E=M*C^2", "e=m*c^2")).isEqualTo(65536);
  }
}
