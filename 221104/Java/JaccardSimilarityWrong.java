import java.util.HashMap;
import java.util.Map;

public class JaccardSimilarity {

  public String toUpperCase(String text) {
    return text.toUpperCase();
  }

  public String deleteNonAlphabeticalCharacters(String text) {
    StringBuilder renewedText = new StringBuilder();

    for (int i = 0; i < text.length(); i += 1) {
      char previousWord = i >= 1 ? text.charAt(i - 1) : 'A';
      char word = text.charAt(i);
      char nextWord = i < text.length() - 1 ? text.charAt(i + 1) : 'A';

      if (previousWord < 65 || previousWord > 90 ||
          word < 65 || word > 90 ||
          nextWord < 65 || nextWord > 90) {
        continue;
      }
      renewedText.append(word);
    }

    return renewedText.toString();
  }

  public Map<String, Integer> makeMap(String text) {
    Map<String, Integer> multiples = new HashMap<>();

    for (int i = 0; i < text.length() - 1; i += 1) {
      String part = text.substring(i, i + 2);

      if (!multiples.containsKey(part)) {
        multiples.put(part, 1);
        continue;
      }

      multiples.replace(part, multiples.get(part) + 1);
    }

    return multiples;
  }

  public double calculateIntersectionCount(Map<String, Integer> multiples1,
                                           Map<String, Integer> multiples2) {
    double intersectionCount = 0;

    for (String keyOfMultiple1 : multiples1.keySet()) {
      for (String keyOfMultiple2 : multiples2.keySet()) {
        if (keyOfMultiple1.equals(keyOfMultiple2)) {
          int countOfMultiple1 = multiples1.get(keyOfMultiple1);
          int countOfMultiple2 = multiples1.get(keyOfMultiple2);

          intersectionCount += Math.min(countOfMultiple1, countOfMultiple2);
        }
      }
    }

    return intersectionCount;
  }

  public double calculateUnionCount(Map<String, Integer> multiples1,
                                    Map<String, Integer> multiples2) {
    double unionCount = 0;

    for (String keyOfMultiple1 : multiples1.keySet()) {
      int countOfMultiple1 = multiples1.get(keyOfMultiple1);

      if (multiples2.containsKey(keyOfMultiple1)) {
        int countOfMultiple2 = multiples1.get(keyOfMultiple1);
        unionCount += Math.max(countOfMultiple1, countOfMultiple2);
        multiples2.remove(keyOfMultiple1);
        continue;
      }

      unionCount += countOfMultiple1;
    }

    for (String keyOfMultiple2 : multiples2.keySet()) {
      int countOfMultiple2 = multiples2.get(keyOfMultiple2);
      unionCount += countOfMultiple2;
    }

    return unionCount;
  }

  public double jaccardSimilarity(double intersectionCount, double unionCount) {
    return intersectionCount == 0 && unionCount == 0
        ? 1
        : Math.floor((intersectionCount / unionCount) * 65536);
  }

  public int solution(String text1, String text2) {
    String capitalizedText1 = toUpperCase(text1);
    String modifiedText1 = deleteNonAlphabeticalCharacters(capitalizedText1);
    Map<String, Integer> multiples1 = makeMap(modifiedText1);

    String capitalizedText2 = toUpperCase(text2);
    String modifiedText2 = deleteNonAlphabeticalCharacters(capitalizedText2);
    Map<String, Integer> multiples2 = makeMap(modifiedText2);

    double intersectionCount = calculateIntersectionCount(multiples1, multiples2);
    double unionCount = calculateUnionCount(multiples1, multiples2);

    return (int) jaccardSimilarity(intersectionCount, unionCount);
  }
}
