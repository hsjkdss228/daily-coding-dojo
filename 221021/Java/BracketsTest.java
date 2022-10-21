import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 괄호를 하나씩 세면서 여는 괄호가 나오는 개수를 카운트한다.
// 여는 괄호가 나오면 카운트를 1 증가시킨다.
// 닫는 괄호가 나오면 카운트를 1 감소시킨다.
// 닫는 괄호가 나왔는데 여는 괄호의 개수 카운트가 0 이하인 경우가 나타난다면 잘못된 경우이다.
// 모든 괄호를 셌는데 여는 괄호의 개수 카운트가 1 이상이라면 잘못된 경우이다.

class BracketsTest {
//  @Test
//  void isEqualNumberOfBrackets() {
//    Brackets test = new Brackets();
//
//    assertThat(test.isEqualNumberOfBrackets(new String[]{"(", "(", ")", ")"}))
//        .isTrue();
//  }

  @Test
  void increaseOpenBracketCount() {
    Brackets test = new Brackets();

    test.increaseOpenBracketCount();
    assertThat(test.openBracketCount()).isEqualTo(1);
  }

  @Test
  void decreaseOpenBracketCount() {
    Brackets test = new Brackets();

    test.increaseOpenBracketCount();
    test.decreaseOpenBracketCount();
    assertThat(test.openBracketCount()).isEqualTo(0);
  }

  @Test
  void lessClosingBrackets() {
    Brackets test = new Brackets();

    test.increaseOpenBracketCount();
    assertThat(test.moreClosingBrackets()).isFalse();
  }

  @Test
  void moreClosingBrackets() {
    Brackets test = new Brackets();

    test.decreaseOpenBracketCount();
    assertThat(test.moreClosingBrackets()).isTrue();
  }

  @Test
  void existsBracketNotClosed() {
    Brackets test = new Brackets();

    test.increaseOpenBracketCount();
    test.increaseOpenBracketCount();
    test.decreaseOpenBracketCount();
    assertThat(test.existsBracketNotClosed()).isTrue();
  }

//  @Test
//  void split() {
//    Brackets test = new Brackets();
//
//    assertThat(test.split("(())()()"))
//        .isEqualTo(new String[]{"(", "(", ")", ")", "(", ")", "(", ")"});
//  }

  @Test
  void checkOpenBracket() {
    Brackets test = new Brackets();

    test.checkBracket("(");
    assertThat(test.openBracketCount()).isEqualTo(1);
  }

  @Test
  void checkClosingBracket() {
    Brackets test = new Brackets();

    test.checkBracket(")");
    assertThat(test.openBracketCount()).isEqualTo(-1);
  }

  @Test
  void solution() {
    Brackets test = new Brackets();

    assertThat(test.solution("()()")).isTrue();
    assertThat(test.solution("(()())()")).isTrue();
    assertThat(test.solution(")()(")).isFalse();
    assertThat(test.solution("(()(")).isFalse();
  }
}
