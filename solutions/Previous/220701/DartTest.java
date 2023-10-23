import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DartTest {
  @Test
  void oneSetNoIncludeOption() {
    Dart dart = new Dart();

    assertEquals(3, dart.solution("3S"));
  }

  @Test
  void twoSetNoIncludeOption() {
    Dart dart = new Dart();

    assertEquals(17, dart.solution("3D2T"));
  }

  @Test
  void setsIncludeStarOptionFirst() {
    Dart dart = new Dart();

    assertEquals(2, dart.solution("1S*"));
  }

  @Test
  void amolangTest() {
    Dart dart = new Dart();

    assertEquals(37, dart.solution("1S2D*3T"));
    assertEquals(9, dart.solution("1D2S#10S"));
    assertEquals(3, dart.solution("1D2S0T"));
    assertEquals(23, dart.solution("1S*2T*3S"));
    assertEquals(5, dart.solution("1D#2S*3S"));
    assertEquals(-4, dart.solution("1T2D3D#"));
    assertEquals(59, dart.solution("1D2S3T*"));
  }
}
