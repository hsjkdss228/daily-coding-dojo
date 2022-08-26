import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeNumeralWordsTest {
  @Test
  void previousTest() {
    String word = "fourzeroninetwozero";

    System.out.println(word.indexOf("zero"));
    System.out.println(word.lastIndexOf("zero"));

    //---
    System.out.println(word.indexOf("zero") + ("zero".length() - 1));

    String four = word.substring(0, "zero".length());
    System.out.println(four);
    String stringRemaining = word.substring("zero".length());
    System.out.println(stringRemaining);

    //---
    word = word.substring("four".length());
    if (word.startsWith("zero")) {
      System.out.println("four를 성공적으로 잘라냈다!!!");
    }
  }
}