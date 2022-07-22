public class CaesarPassword {
  public String solution(String input, int index) {
    String answer = "";

    for (int i = 0; i < input.length(); i += 1) {
      char word = input.charAt(i);

      if (word == ' ') {
        answer += word;
        continue;
      }

      char modified = (char) (word + index);

      boolean isExceededLastIndexOfUpperCase
          = (word >= 'A' && word <= 'Z') && modified > 'Z';

      boolean isExceededLastIndexOfLowerCase
          = (word >= 'a' && word <= 'z') && modified > 'z';

      if (isExceededLastIndexOfUpperCase || isExceededLastIndexOfLowerCase) {
        modified -= 26;
      }

      answer += modified;
    }

    return answer;
  }
}
