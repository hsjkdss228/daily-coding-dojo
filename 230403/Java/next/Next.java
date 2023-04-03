public class Next {
    public enum SequenceType {
        ARITHMETIC,
        GEOMETRIC;
    }

    public static class Sequence {
        private final SequenceType type;
        private final int difference;

        public Sequence(SequenceType type, int difference) {
            this.type = type;
            this.difference = difference;
        }

        public static Sequence determine(int[] common) {
            int differenceSecondFirst = common[1] - common[0];
            int differenceThirdSecond = common[2] - common[1];

            boolean isDifferent = differenceThirdSecond == differenceSecondFirst;
            SequenceType type = isDifferent
                ? SequenceType.ARITHMETIC
                : SequenceType.GEOMETRIC;
            int difference = isDifferent
                ? differenceThirdSecond
                : differenceThirdSecond / differenceSecondFirst;
            return new Sequence(type, difference);
        }

        public SequenceType type() {
            return type;
        }

        public int difference() {
            return difference;
        }
    }

    public int solution(int[] common) {
        Sequence sequence = Sequence.determine(common);
        return sequence.type() == SequenceType.ARITHMETIC
            ? common[common.length - 1] + sequence.difference()
            : common[common.length - 1] * sequence.difference();
    }
}
