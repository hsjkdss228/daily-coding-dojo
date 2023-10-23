public class WeirdString {
  public String solution(String normalString) {
    String[] weirdString = new String[normalString.length()];
    int wordIndex = 0;

    for (int i = 0; i < weirdString.length; i += 1, wordIndex += 1) {
      if (normalString.charAt(i) == ' ') {
        weirdString[i] = " ";
        wordIndex = -1;
        continue;
      }

      if (wordIndex % 2 == 0) {
        weirdString[i]
            = Character.toString(normalString.charAt(i)).toUpperCase();
      }

      if (wordIndex % 2 == 1) {
        weirdString[i]
            = Character.toString(normalString.charAt(i)).toLowerCase();
      }
    }

    return String.join("", weirdString);
  }
}
