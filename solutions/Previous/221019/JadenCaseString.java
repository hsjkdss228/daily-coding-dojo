public class JadenCaseString {
  public String solution(String strings) {
    String[] splitStrings = split(strings);

    for (int i = 0; i < splitStrings.length; i += 1) {
      splitStrings[i] = changeCharacters(splitStrings[i]);
    }

    return concatenate(splitStrings);
  }

  public String changeCharacters(String word) {
    char[] convertedWord = word.toCharArray();

    for (int i = 0; i < convertedWord.length; i += 1) {
      convertedWord[i] = i == 0
          ? Character.toUpperCase(convertedWord[i])
          : Character.toLowerCase(convertedWord[i]);
    }

    return String.valueOf(convertedWord);
  }

  public String[] split(String strings) {
    return strings.split(" ", -1);
  }

  public String concatenate(String[] convertedWords) {
    return String.join(" ", convertedWords);
  }
}

//  public String solution(String strings) {
//    String[] splitStrings = split(strings);
//
//    splitStrings = changeCharacters(splitStrings);
//
//    return concatenate(splitStrings);
//  }
//
//  public String[] changeCharacters(String[] string) {
//    boolean
//
//    for (int i = 0; i < string.length - 1; i += 1) {
//      if (i == 0) {
//        string[i] = string[i].charAt(0) < 65 || string[i].charAt(0) > 90
//            ? string[i].toUpperCase()
//            : string[i].toLowerCase();
//        continue;
//      }
//
//      string[i] = string[i].isBlank()
//          ? string[i].toUpperCase()
//          : string[i].toLowerCase();
//    }
//
//    return string;
//  }
//
//  public String[] split(String strings) {
//    return strings.split("");
//  }
//
//  public String concatenate(String[] convertedStrings) {
//    return String.join("", convertedStrings);
//  }