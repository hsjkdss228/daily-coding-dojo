import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1. 하나의 문자열에 대해
//  맨 앞 글자는 대문자로, 맨 뒷 글자는 소문자로 변경
// 2. 전체 문자열을 빈칸을 기준으로 각각의 문자열로 쪼갬
// 3. 각각의 쪼개진 문자열에 대해 1을 수행
// 4. 결과 문자열들을 다시 모두 합침

class JadenCaseStringTest {
  @Test
  void changeCharactersWithOnlyAlphabet() {
    JadenCaseString test = new JadenCaseString();

    assertThat(test.changeCharacters("hOLy")).isEqualTo("Holy");
  }

  @Test
  void changeCharactersWithNumericCharacter() {
    JadenCaseString test = new JadenCaseString();

    assertThat(test.changeCharacters("1twoTHREe")).isEqualTo("1twothree");
  }

//  @Test
  void split() {
    JadenCaseString test = new JadenCaseString();

    assertThat(test.split("howl'S MOVINg 3AsTle"))
        .isEqualTo(new String[]{"howl'S", "MOVINg", "3AsTle"});
  }

  @Test
  void splitWithOneWord() {
    JadenCaseString test = new JadenCaseString();

    assertThat(test.split("Hi"))
        .isEqualTo(new String[]{"Hi"});
  }

  @Test
  void concatenate() {
    JadenCaseString test = new JadenCaseString();

    assertThat(test.concatenate(new String[]{"howl'S", "MOVINg", "3AsTle"}))
        .isEqualTo("howl'S MOVINg 3AsTle");
  }

  @Test
  void solution() {
    JadenCaseString test = new JadenCaseString();

    assertThat(test.solution("3people unFollowed me"))
        .isEqualTo("3people Unfollowed Me");
    assertThat(test.solution("for the last week    "))
        .isEqualTo("For The Last Week    ");
  }
}
