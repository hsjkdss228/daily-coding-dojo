import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {
  @Test
  void solution() {
    Budget budget = new Budget();

    assertEquals(6, budget.solution2(new int[]{6, 2, 34, 7, 15, 55, 28, 9}, 80));
  }

  @Test
  void solution2() {
    Budget budget = new Budget();

    assertEquals(3, budget.solution2(new int[]{1, 3, 2, 5, 4}, 9));
  }

  @Test
  void solution3() {
    Budget budget = new Budget();

    assertEquals(4, budget.solution2(new int[]{2, 2, 3, 3}, 10));
  }
}
