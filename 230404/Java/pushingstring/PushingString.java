public class PushingString {
    public int solution(String original, String target) {
        int changedCount = 0;

        if (original.equals(target)) {
            return changedCount;
        }
        String changed = change(original);
        changedCount += 1;
        do {
            if (changed.equals(target)) {
                return changedCount;
            }
            changed = change(changed);
            changedCount += 1;
        } while (different(changed, original));

        return -1;
    }

    public String change(String string) {
        return string.charAt(string.length() - 1)
            + string.substring(0, string.length() - 1);
    }

    public boolean different(String changed, String original) {
        return !changed.equals(original);
    }
}
