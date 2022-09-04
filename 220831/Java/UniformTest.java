import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniformTest {
  @Test
  void solution() {
    Uniform test = new Uniform();

    assertEquals(
        6,
        test.solution(8, new int[]{1, 3, 4, 6, 7}, new int[]{2, 5, 6})
    );

    assertEquals(
        28,
        test.solution(
            30,
            new int[]{1, 2, 3},
            new int[]{4, 5, 6, 7}
        )
    );

    assertEquals(
        5,
        test.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})
    );

    assertEquals(
        4,
        test.solution(5, new int[]{2, 4}, new int[]{3})
    );

    assertEquals(
        2,
        test.solution(3, new int[]{3}, new int[]{1})
    );
    
    assertEquals(
        4,
        test.solution(5, new int[]{1, 2}, new int[]{2, 3})
    );

    assertEquals(5,test.solution(5,new int[] {1,2},new int[] {1,2}));
    assertEquals(4,test.solution(5,new int[] {2,3,4},new int[] {3,5}));
    assertEquals(2,test.solution(3,new int[] {1,2},new int[] {2,3}));
    assertEquals(8,test.solution(9,new int[] {5,6,8,1,2},new int[] {2,3,1,4,8,9}));
    assertEquals(6,test.solution(6,new int[] {2,4,5},new int[] {1,3,6}));
    assertEquals(5,test.solution(5,new int[] {2,4,6},new int[] {1,3,5,7}));

    assertEquals(
        10,
        test.solution(
            10,
            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        )
    );

    assertEquals(
        9,
        test.solution(
            10,
            new int[]{1, 2, 3, 4, 5, 6},
            new int[]{1, 2, 3, 4, 6, 7}
        )
    );

    assertEquals(
        6,
        test.solution(
            7,
            new int[]{2, 3, 5},
            new int[]{3, 4}
        )
    );

    assertEquals(
        6,
        test.solution(
            7,
            new int[]{2, 3, 5},
            new int[]{3, 4}
        )
    );

    assertEquals(
        1,
        test.solution(
            6,
            new int[]{1, 2, 3, 4, 5, 6},
            new int[]{1}
        )
    );

    assertEquals(
        6,
        test.solution(
            6,
            new int[]{1},
            new int[]{1, 2, 3, 4, 5, 6}
        )
    );

    assertEquals(
        1,
        test.solution(
            2,
            new int[]{1, 2},
            new int[]{1}
        )
    );

    assertEquals(
        3,
        test.solution(
            7,
            new int[]{1, 2, 3, 5, 6, 7},
            new int[]{3, 4, 5}
        )
    );

    assertEquals(
        3,
        test.solution(
            7,
            new int[]{1, 2, 3, 5, 6, 7},
            new int[]{3, 4, 5}
        )
    );
  }
}
