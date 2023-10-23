import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubsequenceSums {
    public static class Sequence {
        private final Map<Integer, Integer> elementsAndCounts;
        private int sum;

        public Sequence(Map<Integer, Integer> elementsAndCounts, int sum) {
            this.elementsAndCounts = elementsAndCounts;
            this.sum = sum;
        }

        public static Sequence of(int element) {
            Map<Integer, Integer> elementsAndCounts = new HashMap<>();
            elementsAndCounts.put(element, 1);
            return new Sequence(elementsAndCounts, element);
        }

        public void addElement(int element) {
            if (elementsAndCounts.containsKey(element)) {
                int count = elementsAndCounts.get(element);
                elementsAndCounts.replace(element, count + 1);
                sum += element;
                return;
            }
            elementsAndCounts.put(element, 1);
            sum += element;
        }

        public int sum() {
//            return elementsAndCounts.entrySet()
//                .stream()
//                .map(elementAndCount -> {
//                    int element = elementAndCount.getKey();
//                    int count = elementAndCount.getValue();
//                    return element * count;
//                })
//                .reduce(0, Integer::sum);
            return sum;
        }

//        @Override
//        public boolean equals(Object other) {
//            if (this == other) {
//                return true;
//            }
//            if (other == null || getClass() != other.getClass()) {
//                return false;
//            }
//            Sequence otherSequence = (Sequence) other;
//            for (Map.Entry<Integer, Integer> otherElementAndCount
//                : otherSequence.elementsAndCounts.entrySet()) {
//                int otherElement = otherElementAndCount.getKey();
//                if (!elementsAndCounts.containsKey(otherElement)) {
//                    return false;
//                }
//                int count = elementsAndCounts.get(otherElement);
//                int otherCount = otherElementAndCount.getValue();
//                if (count != otherCount) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        @Override
//        public int hashCode() {
//            int code = 0;
//            for (Map.Entry<Integer, Integer> elementAndCount
//                : elementsAndCounts.entrySet()) {
//                int element = elementAndCount.getKey();
//                int count = elementAndCount.getValue();
//                code += Objects.hash(element, count);
//            }
//            return code;
//        }

        @Override
        public String toString() {
            return "{" + elementsAndCounts + "}";
        }
    }

    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        List<Sequence> subsequences = createFirstSubsequences(elements);
        subsequences.forEach(subsequence -> sums.add(subsequence.sum()));

        int[] concatenatedElements = concatenate(elements);
        int startIndex = 1;
        while (startIndex < elements.length) {
            for (int i = startIndex; i < elements.length + startIndex; i += 1) {
                int sequenceIndex = i - startIndex;
                Sequence subsequence = subsequences.get(sequenceIndex);
                subsequence.addElement(concatenatedElements[i]);
                sums.add(subsequence.sum());
            }
            startIndex += 1;
        }

//        for (int length = 1; length <= elements.length; length += 1) {
//            for (int start = 0; start < elements.length; start += 1) {
//                int end = start + length;
//                int[] subArray = partOf(concatenated, start, end);
//                Sequence subsequence = Sequence.of(subArray);
//                sums.add(subsequence.sum());
//            }
//        }

        return sums.size();
    }

    public int[] concatenate(int[] elements) {
        List<Integer> concatenated = Arrays.stream(elements)
            .boxed()
            .collect(Collectors.toList());
        IntStream.range(0, elements.length - 1)
            .forEach(index -> concatenated.add(elements[index]));
        return concatenated.stream()
            .mapToInt(element -> element)
            .toArray();
    }

    public List<Sequence> createFirstSubsequences(int[] elements) {
        return Arrays.stream(elements)
            .mapToObj(Sequence::of)
            .collect(Collectors.toList());
    }
}
