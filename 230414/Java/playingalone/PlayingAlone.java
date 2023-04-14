import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayingAlone {
    public int solution(int[] cards) {
        Map<Integer, Integer> boxAndCardNumbers = mapOf(cards);
        List<Integer> boxesCounts = new ArrayList<>();
        countBoxesInGroup(boxAndCardNumbers, boxesCounts);
        return calculateAnswer(boxesCounts);
    }

    public Map<Integer, Integer> mapOf(int[] cards) {
        Map<Integer, Integer> boxAndCardNumbers = new HashMap<>();
        for (int i = 0; i < cards.length; i += 1) {
            int boxNumber = i + 1;
            int cardNumber = cards[i];
            boxAndCardNumbers.put(boxNumber, cardNumber);
        }
        return boxAndCardNumbers;
    }

    public void countBoxesInGroup(Map<Integer, Integer> boxAndCardNumbers,
                                  List<Integer> boxesCounts) {
        while (!boxAndCardNumbers.isEmpty()) {
            Map.Entry<Integer, Integer> boxAndCardNumber
                = boxAndCardNumbers.entrySet()
                .stream()
                .findFirst()
                .get();
            int count = 0;
            int boxNumber = boxAndCardNumber.getKey();
            while (boxAndCardNumbers.containsKey(boxNumber)) {
                int previousBoxNumber = boxNumber;
                boxNumber = boxAndCardNumbers.get(boxNumber);
                boxAndCardNumbers.remove(previousBoxNumber);
                count += 1;
            }
            boxesCounts.add(count);
        }
    }

    private boolean hasOneCount(List<Integer> boxesCounts) {
        return boxesCounts.size() == 1;
    }

    private List<Integer> countTopTwoBoxesCounts(List<Integer> boxesCounts) {
        return boxesCounts
            .stream()
            .sorted(Comparator.reverseOrder())
            .limit(2)
            .collect(Collectors.toList());
    }

    private int calculateAnswer(List<Integer> boxesCounts) {
        if (hasOneCount(boxesCounts)) {
            return 0;
        }
        List<Integer> top2BoxesCounts = countTopTwoBoxesCounts(boxesCounts);
        int first = top2BoxesCounts.get(0);
        int second = top2BoxesCounts.get(1);
        return first * second;
    }
}
