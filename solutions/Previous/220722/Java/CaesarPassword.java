import java.util.Arrays;
import java.util.stream.Collectors;

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

  public String solution2(String input, int index) {
    int[] words = input.chars().map(word -> {
      if (word == ' ') {
        return ' ';
      }
      char modified = (char) (word + index);
      return (word >= 'a' && word <= 'z' && modified <= 'z')
          || (word >= 'A' && word <= 'Z' && modified <= 'Z')
            ? modified
            : modified - 26;
    }).toArray();

    return Arrays.stream(words)
        .mapToObj(word -> Character.toString((char) word))
        .collect(Collectors.joining());
  }
}
