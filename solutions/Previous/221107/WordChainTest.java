import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordChainTest {
  @Test
  void updateUserNumber() {
    WordChain test = new WordChain();

    int users = 3;
    int userNumber = 1;
    int userTurn = 1;
    int[] userNumberAndTurn
        = test.addUserNumberOrTurn(users, userNumber, userTurn);

    assertThat(userNumberAndTurn[0]).isEqualTo(2);
    assertThat(userNumberAndTurn[1]).isEqualTo(1);
  }

  @Test
  void updateUserTurn() {
    WordChain test = new WordChain();

    int users = 3;
    int userNumber = 3;
    int userTurn = 1;
    int[] userNumberAndTurn
        = test.addUserNumberOrTurn(users, userNumber, userTurn);

    assertThat(userNumberAndTurn[0]).isEqualTo(1);
    assertThat(userNumberAndTurn[1]).isEqualTo(2);
  }

  @Test
  void solutionCase1() {
    WordChain test = new WordChain();

    int users = 3;
    String[] words = new String[]{"tank", "kick", "know", "wheel", "land",
        "dream", "mother", "robot", "tank"};
    assertThat(test.solution(users, words)).isEqualTo(new int[]{3, 3});
  }

  @Test
  void solutionCase2() {
    WordChain test = new WordChain();

    int users = 5;
    String[] words = new String[]{"hello", "observe", "effect", "take",
        "either", "recognize", "encourage", "ensure", "establish", "hang",
        "gather", "refer", "reference", "estimate", "executive"};
    assertThat(test.solution(users, words)).isEqualTo(new int[]{0, 0});
  }

  @Test
  void solutionCase3() {
    WordChain test = new WordChain();

    int users = 2;
    String[] words = new String[]{"hello", "one", "even", "never", "now",
        "world", "draw"};
    assertThat(test.solution(users, words)).isEqualTo(new int[]{1, 3});
  }
}