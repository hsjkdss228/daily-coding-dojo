// 영단어가 포함된 숫자를 문자열에서 어떻게 읽을 것인가?
// 어떻게 읽어야 할지 모르겠으니까 String 메서드로 실험을 해 본다.

// indexOf로 단어의 시작 위치를 찾을 수 있다.
// 대신 indexOf는 똑같은 단어가 여러 개 있어도 첫 단어의 시작 위치만 알려준다.
// 지금 생각나는 방법은
// 단어를 찾았으면 그 단어는 문자열에서 제거하고,
// 뽑아온 단어를 숫자로 바꿔서 정답 문자열에 추가할 수 있을 것 같다.

// 오! lastIndexOf로 단어의 끝 위치도 알 수 있다!
// 아쉽게도 마지막부터 탐색하기 때문에 같은 단어가 중복해서 문자열에 있으면
// 뒤쪽에 있는 단어의 끝 위치를 알려준다.
// 인 줄 알았는데? 단순히 단어의 첫 위치를 문자열의 뒤쪽에서 찾는 메서드였다. 실망스럽다.

// stackoverflow 형님께서 알려주시는
// indexOf만 있어도 그 단어의 끝 위치를 알 수 있는 방법에 대한 글을 찾았다.
// 바로 indexOf(word) + (word.length() - 1)
// 천잰가? 이걸 어떻게 생각해내지?

// 아무튼 문자열에서 한 단어의 시작 위치와 끝 위치를 알아냈다.
// 그럼 이제 문자열에서 앞에서부터 한 단어를 뽑아내는 것도 가능해졌고,
// 뽑아낸 단어를 문자열에서 제거하는 것도 substring()을 이용하면 가능하다.
// 어떻게? 생각해보니 substring()만으로 단어 뽑아내기와
// 그 단어 원래 문자열에서 제거하기가 둘 다 가능하다.
// 뽑아내는 건 word.substring(0, "zero".length())
// 원래 문자열에서 뽑아낸 단어를 제거하는 건 word.substring("zero".length())

// "zero" 자리에 단어만 잘 설정해서 주면 될 것 같다.
// 어떻게? startsWith()로 할 수 있을지 실험해보자.
// startsWith()로 어떤 단어로 시작하는지 찾을 수 있다!
// 그럼 이제 5개의 단어가 들어간 문자를 주고 2개의 단어를 잘라내서 추출하는 과정을 만들어보자.

// ...
// 과정은 나중에 만들어 보자.
// replace() 메서드로 대체하도록 하자.

public class ChangeNumeralWords {
  public int solution(String numeralWords) {
    numeralWords = numeralWords.replace("zero", "0");
    numeralWords = numeralWords.replace("one", "1");
    numeralWords = numeralWords.replace("two", "2");
    numeralWords = numeralWords.replace("three", "3");
    numeralWords = numeralWords.replace("four", "4");
    numeralWords = numeralWords.replace("five", "5");
    numeralWords = numeralWords.replace("six", "6");
    numeralWords = numeralWords.replace("seven", "7");
    numeralWords = numeralWords.replace("eight", "8");
    numeralWords = numeralWords.replace("nine", "9");

    return Integer.parseInt(numeralWords);
  }
}
