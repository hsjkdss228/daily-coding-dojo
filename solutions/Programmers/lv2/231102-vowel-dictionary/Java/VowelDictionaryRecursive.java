import java.util.List;

public class VowelDictionaryRecursive {
    public enum Index {
        First(0),
        Second(1),
        Third(2),
        Fourth(3),
        Fifth(4);

        public final int value;

        Index(int value) {
            this.value = value;
        }

        public boolean isUnderFifth() {
            return this.value < Fifth.value;
        }

        public Index plus() {
            return switch (this) {
                case First -> Second;
                case Second -> Third;
                case Third -> Fourth;
                case Fourth -> Fifth;
                case Fifth -> null;
            };
        }
    }

    private final List<Character> vowels = List.of('A', 'E', 'I', 'O', 'U');

    private boolean found = false;

    public int solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        int order = 0;

        return insertVowelAtIndex(stringBuilder, Index.First, order, word);
    }

    private int insertVowelAtIndex(StringBuilder stringBuilder,
                                   Index index,
                                   int order,
                                   String word) {
        for (Character vowel : vowels) {
            order += 1;

            if (createdWordEquals(stringBuilder, vowel, index, word)) {
                found = true;
                return order;
            }

            if (index.isUnderFifth()) {
                int sum = insertVowelAtIndex(
                    stringBuilder,
                    index.plus(),
                    order,
                    word
                );
                if (found) {
                    return sum;
                }
                order = sum;
            }

            if (index.isUnderFifth()) {
                stringBuilder.deleteCharAt(index.value);
            }
        }

        return order;
    }

    private boolean createdWordEquals(StringBuilder stringBuilder,
                                      Character character,
                                      Index index,
                                      String word) {
        if (character != 'A') {
            stringBuilder.deleteCharAt(index.value);
        }

        String other = stringBuilder
            .append(character)
            .toString();

        return other.equals(word);
    }
}
