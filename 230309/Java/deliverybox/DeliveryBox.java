import java.util.Stack;

public class DeliveryBox {
    public int solution(int[] orders) {
        Stack<Integer> tempBoxes = new Stack<>();
        int loadedBoxCount = 0;
        int boxIndexShouldBeLoaded = 0;

        for (int boxIndexCurrent = 1;
             boxIndexCurrent <= orders.length;
             boxIndexCurrent += 1) {
            boxIndexShouldBeLoaded = orders[loadedBoxCount];

            if (boxIndexCurrent == boxIndexShouldBeLoaded) {
                loadedBoxCount += 1;
                continue;
            }

            while (!tempBoxes.isEmpty()
                && tempBoxes.peek() == boxIndexShouldBeLoaded) {
                loadedBoxCount += 1;
                tempBoxes.pop();

                boxIndexShouldBeLoaded = orders[loadedBoxCount];
            }

            if (boxIndexCurrent > boxIndexShouldBeLoaded) {
                return loadedBoxCount;
            }

            tempBoxes.push(boxIndexCurrent);
        }

        boxIndexShouldBeLoaded = orders[loadedBoxCount];

        while (!tempBoxes.isEmpty()
            && tempBoxes.peek() == boxIndexShouldBeLoaded) {

            loadedBoxCount += 1;
            tempBoxes.pop();
            if (!tempBoxes.isEmpty()) {
                boxIndexShouldBeLoaded = orders[loadedBoxCount];
            }
        }

        return loadedBoxCount;
    }
}
