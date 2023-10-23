import java.util.stream.IntStream;

public class FindKim {
    public String solution(String[] seoul) {
        int foundIndex = IntStream.range(0, seoul.length)
            .filter(index -> seoul[index].equals("Kim"))
            .findFirst()
            .getAsInt();

        return "김서방은 " + foundIndex + "에 있다";
    }
}
