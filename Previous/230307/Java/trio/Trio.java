import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Trio {
    public static class Indices {
        private final int index1;
        private final int index2;
        private final int index3;

        public Indices(int index1, int index2, int index3) {
            this.index1 = index1;
            this.index2 = index2;
            this.index3 = index3;
        }

        public static Indices of(int index1, int index2, int index3) {
            return new Indices(index1, index2, index3);
        }

//        public int index1() {
//            return index1;
//        }
//
//        public int index2() {
//            return index2;
//        }
//
//        public int index3() {
//            return index3;
//        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Indices other = (Indices) object;
            return (this.index1 == other.index1
                && this.index2 == other.index2
                && this.index3 == other.index3)
                || (this.index1 == other.index1
                && this.index2 == other.index3
                && this.index3 == other.index2)
                || (this.index1 == other.index2
                && this.index2 == other.index1
                && this.index3 == other.index3)
                || (this.index1 == other.index2
                && this.index2 == other.index3
                && this.index3 == other.index1)
                || (this.index1 == other.index3
                && this.index2 == other.index1
                && this.index3 == other.index2)
                || (this.index1 == other.index3
                && this.index2 == other.index2
                && this.index3 == other.index1);
        }

        @Override
        public int hashCode() {
//            return Objects.hash(index1, index2, index3);
            return Objects.hash(index1) + Objects.hash(index2) + Objects.hash(index3);
        }

        @Override
        public String toString() {
            return "{" + index1 +
                ", " + index2 +
                ", " + index3 + "}";
        }
    }

    public int solution(int[] numbers) {
        Set<Indices> indicesSet = createIndicesSet(numbers.length);
        return countTrio(numbers, indicesSet);
    }

    public Set<Indices> createIndicesSet(int length) {
        Set<Indices> indicesSet = new HashSet<>();
        for (int index1 = 0; index1 < length; index1 += 1) {
            for (int index2 = 0; index2 < length; index2 += 1) {
                if (index2 == index1) {
                    continue;
                }
                for (int index3 = 0; index3 < length; index3 += 1) {
                    if (index3 == index1 || index3 == index2) {
                        continue;
                    }
                    Indices indices = new Indices(index1, index2, index3);

                    indicesSet.add(indices);
//                    boolean contains = contains(indicesSet, indices);
//                    if (!contains) {
//                        indicesSet.add(indices);
//                    }
                }
            }
        }
        return indicesSet;
    }

//    public boolean contains(Set<Indices> indicesSet, Indices indices) {
//        boolean contains = false;
//        for (Indices added : indicesSet) {
//            if ((added.index1 == indices.index1
//                && added.index2 == indices.index2
//                && added.index3 == indices.index3)
//                || (added.index1 == indices.index1
//                && added.index2 == indices.index3
//                && added.index3 == indices.index2)
//                || (added.index1 == indices.index2
//                && added.index2 == indices.index1
//                && added.index3 == indices.index3)
//                || (added.index1 == indices.index2
//                && added.index2 == indices.index3
//                && added.index3 == indices.index1)
//                || (added.index1 == indices.index3
//                && added.index2 == indices.index1
//                && added.index3 == indices.index2)
//                || (added.index1 == indices.index3
//                && added.index2 == indices.index2
//                && added.index3 == indices.index1)) {
//                contains = true;
//                break;
//            }
//        }
//        return contains;
//    }

    public int countTrio(int[] numbers, Set<Indices> indicesSet) {
        int answer = 0;
        for (Indices indices : indicesSet) {
            if (isTrio(numbers, indices)) {
                answer += 1;
            }
        }
        return answer;
    }

    public boolean isTrio(int[] numbers, Indices indices) {
        int number1 = numbers[indices.index1];
        int number2 = numbers[indices.index2];
        int number3 = numbers[indices.index3];
        return number1 + number2 + number3 == 0;
    }
}
