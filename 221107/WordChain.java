import java.util.LinkedHashSet;
import java.util.Set;

public class WordChain {
  public int[] solution(int users, String[] words) {
    Set<String> checkedWords = new LinkedHashSet<>();
    String previousWord = "";
    int userNumber = 1;
    int userTurn = 1;

    String firstWord = words[0];
    checkedWords.add(firstWord);
    previousWord = firstWord;

    for (int i = 0; i < words.length; i += 1) {
//      System.out.println("i: " + i);
      String word = words[i];

//      for (String checkedWord : checkedWords) {
//        System.out.println(checkedWord);
//      }
//      System.out.println("previousWord: " + previousWord);
//      System.out.println("word: " + word);
//      System.out.println("userNumber: " + userNumber);
//      System.out.println("userTurn: " + userTurn);

      if (i == 0) {
        userNumber += 1;
        continue;
      }

//      System.out.println("checkedWords.contains(word): " + checkedWords.contains(word));
      if (checkedWords.contains(word)
          || !(previousWord.charAt(previousWord.length() - 1) == word.charAt(0))) {
        return new int[]{userNumber, userTurn};
      }

      checkedWords.add(word);

      previousWord = word;

      int[] userNumberAndTurn
          = addUserNumberOrTurn(users, userNumber, userTurn);
      userNumber = userNumberAndTurn[0];
      userTurn = userNumberAndTurn[1];

      System.out.println();
    }

    return new int[]{0, 0};
  }

  public int[] addUserNumberOrTurn(int users,
                                   int userNumber,
                                   int userTurn) {
    userTurn = userNumber == users
        ? userTurn + 1
        : userTurn;
    userNumber = userNumber == users
        ? 1
        : userNumber + 1;

    return new int[]{userNumber, userTurn};
  }
}
