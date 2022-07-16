import java.util.LinkedList;
import java.util.List;

public class DescendingOrder {
  public String solution(String text) {
    List<Character> wordsList = new LinkedList<>();

    for (int i = 0; i < text.length(); i += 1) {
      char word = text.charAt(i);

//      System.out.println("word: " + word);

      if (i == 0) {
        wordsList.add(word);
//        System.out.println("첫 단어로 " + word + " 넣음");
//        System.out.println(wordsList.get(0));
        continue;
      }

//      System.out.println("wordsList.size(): " + wordsList.size());

      for (int j = 0; j < wordsList.size(); j += 1) {
//        System.out.println("wordsList[" + j + "]: " + wordsList.get(j));
//        System.out.println("word - wordsList.get(j): "
//            + (word - wordsList.get(j)));

        if ((j == 0) && word >= wordsList.get(j)) {
//          System.out.println("첫 단어 앞에 " + word + " 넣음");
          wordsList.add(0, word);
          break;
        }

        if ((j >= 1) && (j <= wordsList.size() - 1)
            && word >= wordsList.get(j)) {
//          System.out.println((j + 1) + "번째 단어 앞에 " + word + " 넣음");
          wordsList.add(j, word);
          break;
        }

        if ((j == wordsList.size() - 1) && word < wordsList.get(j)) {
//          System.out.println("마지막 단어 뒤에 " + word + " 넣음");
          wordsList.add(word);
          break;
//          여기에도 break를 넣지 않으면 조건 검사에 쓰이는 wordsList의 크기가 1 증가하기 때문에
//          의도대로 반복문이 종료되지 않고 늘어난 wordsList의 크기에 맞춰서
//          반복문이 계속 수행되게 되는 문제가 있음
//          즉 반복문의 조건 검사에 쓰이는 변수는 조건문 내부의 작업에 의해 변수가 가변되면
//          의도하지 않은 문제를 발생시킬 여지가 있기 때문에
//          조건 검사에 쓸 변수를 따로 상수화시켜서 주던지,
//          의도된 작업을 마치면 break를 해주던지 해야 함
        }
      }

//      for (Character character : wordsList) {
//        System.out.print(character);
//      }
//      System.out.println();
    }

    String answer = "";

    for (Character word : wordsList) {
      answer += word;
    }

    return answer;
  }
}
