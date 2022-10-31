import java.util.ArrayList;
import java.util.List;

public class Carpet {
  public List<Integer> findAllAliquots(int yellowCarpetCount) {
    List<Integer> aliquots = new ArrayList<>();
    aliquots.add(yellowCarpetCount);

    for (int i = yellowCarpetCount - 1; i > 0; i -= 1) {
      if (yellowCarpetCount % i == 0) {
        aliquots.add(i);
      }
    }

    return aliquots;
  }

  public boolean compareToBrownCarpetCount(int[] combination, int brownCarpetCount) {
    return (combination[0] * 2) + (combination[1] * 2) + 4 == brownCarpetCount;
  }

  public int[] solution(int brownCarpetCount, int yellowCarpetCount) {
    List<Integer> aliquots = findAllAliquots(yellowCarpetCount);

    for (int i = 0; i < aliquots.size(); i += 1) {
      int[] combination = new int[]{aliquots.get(i), aliquots.get(aliquots.size() - i - 1)};

      if (compareToBrownCarpetCount(combination, brownCarpetCount)) {
        return new int[]{combination[0] + 2, combination[1] + 2};
      }
    }

    return new int[]{};
  }
}
