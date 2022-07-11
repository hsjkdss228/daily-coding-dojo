import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DescendingOrder {
  private static final int GREATER = 1;
  private static final int LESS = -1;

  public String solution(String text) {
    List<Character> wordsList = new LinkedList<>();

    for (int i = 0; i < text.length(); i += 1) {
      char word = text.charAt(i);

      //System.out.println("word: " + word);

      if (i == 0) {
        wordsList.add(word);
        //System.out.println(wordsList.get(0));
        continue;
      }

      for (int j = 0; j < wordsList.size(); j += 1) {
        //System.out.println("wordsList[" + j + "]: " + wordsList.get(j));

        /*System.out.println("Character.compare(word, wordsList.get(j)): " +
            Character.compare(word, wordsList.get(j)));*/

        if ((j == 0) &&
            Character.compare(word, wordsList.get(j)) >= GREATER) {
          wordsList.add(0, word);
          break;
        }

        if ((j >= 1) && (j <= wordsList.size() - 1) &&
            Character.compare(word, wordsList.get(j)) >= GREATER) {
          wordsList.add(j, word);
          break;
        }

        if ((j == wordsList.size() - 1) &&
            Character.compare(word, wordsList.get(j)) <= LESS) {
          wordsList.add(word);
        }
      }

      /*for (Character character : wordsList) {
        System.out.print(character);
      }
      System.out.println();*/
    }

    String answer = "";

    for (Character word : wordsList) {
      answer += word;
    }

    return answer;
  }
}
