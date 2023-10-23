public class ContainsString {
    public boolean solution(String string1, String string2) {
        if (string2.length() > string1.length()) {
            return false;
        }

        int indexString1 = 0;
        int indexString2 = 0;
        while (indexString2 < string2.length()) {
            if (indexString1 == string1.length()) {
                return false;
            }

            char alphabet1 = string1.charAt(indexString1);
            char alphabet2 = string2.charAt(indexString2);
            if (alphabet1 == alphabet2) {
                indexString1 += 1;
                indexString2 += 1;
                continue;
            }
            indexString1 += 1;
            indexString2 = 0;
        }

        return true;
    }
}
