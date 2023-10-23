import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
  @Test
  void solution() {
    Pokemon test = new Pokemon();

    assertEquals(2, test.solution(new int[]{3, 1, 2, 3}));
    assertEquals(3, test.solution(new int[]{3, 3, 3, 2, 2, 4}));
    assertEquals(2, test.solution(new int[]{3, 3, 3, 2, 2, 2}));
    assertEquals(3, test.solution(new int[]{1, 2, 3, 4, 5, 6}));
    assertEquals(3, test.solution(new int[]{1, 1, 2, 2, 3, 4}));
  }
}
