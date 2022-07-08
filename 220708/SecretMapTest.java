import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecretMapTest {

  @Test
  void decimalToBinaryTest() {
    SecretMap testApplication = new SecretMap();

    assertEquals("01001", testApplication.decimalToBinary(9, 5));
    assertEquals("10100", testApplication.decimalToBinary(20, 5));
    assertEquals("11100", testApplication.decimalToBinary(28, 5));
    assertEquals("10010", testApplication.decimalToBinary(18, 5));
    assertEquals("01011", testApplication.decimalToBinary(11, 5));
  }

  @Test
  void makeSecretMapTest() {
    SecretMap testApplication = new SecretMap();

    String[] binaryArray1 = new String[]{
        "01001",
        "10100",
        "11100",
        "10010",
        "01011"
    };
    String[] binaryArray2 = new String[]{
        "11110",
        "00001",
        "10101",
        "10001",
        "11100"
    };
    String[] expected = new String[]{
        "#####",
        "# # #",
        "### #",
        "#  ##",
        "#####"
    };

    assertArrayEquals(
        expected,
        testApplication.makeSecretMap(5, binaryArray1, binaryArray2)
    );
  }

  @Test
  void solutionTest() {
    SecretMap testApplication = new SecretMap();

    int[] array1 = new int[]{9, 20, 28, 18, 11};
    int[] array2 = new int[]{30, 1, 21, 17, 28};
    String[] expected = new String[]{
        "#####",
        "# # #",
        "### #",
        "#  ##",
        "#####"
    };

    assertArrayEquals(expected, testApplication.solution(5, array1, array2));
  }
}