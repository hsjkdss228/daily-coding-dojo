import java.util.Stack;

public class Pop {
//  public List<Character> convertToList(String alphabets) {
//    List<Character> alphabetsConvertedToList = new ArrayList<>();
//
//    for (int i = 0; i < alphabets.length(); i += 1) {
//      alphabetsConvertedToList.add(alphabets.charAt(i));
//    }
//
//    return alphabetsConvertedToList;
//  }
//
//  public void popConnectedAlphabets(List<Character> alphabets) {
//    for (int i = 0; i < alphabets.size(); i += 1) {
//      if (i >= alphabets.size() - 1) {
//        return;
//      }
//
//      if (alphabets.get(i).equals(alphabets.get(i + 1))) {
//        alphabets.remove(i);
//        alphabets.remove(i);
//        // 두 번째 remove는 어짜피 앞에 것을 remove했을 때 index가 당겨져오기 때문에
//        // 굳이 index를 1 증가시켜서 제거할 필요가 없다. (remove(i + 1)이 아니어도 됨)
//        i -= 1;
//      }
//    }
//  }
//
//  public boolean checkPopped(int previousLength, int currentLength) {
//    return previousLength != currentLength;
//  }
//
//  public boolean checkFinished(int currentLength) {
//    return currentLength == 0;
//  }
//
//  public int solution(String alphabets) {
//    if (alphabets.length() % 2 != 0) {
//      return 0;
//    }
//
//    List<Character> alphabetsConverted = convertToList(alphabets);
//
//    int previousLength = alphabetsConverted.size();
//    while (previousLength >= 2) {
//      popConnectedAlphabets(alphabetsConverted);
//
//      if (!checkPopped(previousLength, alphabetsConverted.size())) {
//        return 0;
//      }
//
//      if (checkFinished(alphabetsConverted.size())) {
//        return 1;
//      }
//
//      previousLength = alphabetsConverted.size();
//    }
//
//    return 0;
//  }

  public int solution(String alphabets) {
    Stack<Character> stack = new Stack();

    for (int i = 0; i < alphabets.length(); i += 1) {
      Character alphabet = alphabets.charAt(i);

      stack.push(alphabet);

      if (stack.size() >= 2 && stack.get(stack.size() - 2) == alphabet) {
        stack.pop();
        stack.pop();
      }
    }

    return stack.isEmpty()
        ? 1
        : 0;
  }
}
