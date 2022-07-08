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

    assertEquals("011", testApplication.decimalToBinary(3, 3));
    assertEquals("110", testApplication.decimalToBinary(6, 3));
    assertEquals("101", testApplication.decimalToBinary(5, 3));
    assertEquals("001", testApplication.decimalToBinary(1, 3));
    assertEquals("111", testApplication.decimalToBinary(7, 3));
    assertEquals("100", testApplication.decimalToBinary(4, 3));
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
    String[] expected1 = new String[]{
        "#####",
        "# # #",
        "### #",
        "#  ##",
        "#####"
    };

    assertArrayEquals(
        expected1,
        testApplication.makeSecretMap(5, binaryArray1, binaryArray2)
    );

    String[] binaryArray3 = new String[]{
        "011",
        "110",
        "101"
    };
    String[] binaryArray4 = new String[]{
        "001",
        "111",
        "100"
    };
    String[] expected2 = new String[]{
        " ##",
        "###",
        "# #"
    };

    assertArrayEquals(
        expected2,
        testApplication.makeSecretMap(3, binaryArray3, binaryArray4)
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