public class StringSplit {
    public int solution(String string) {
        if (string.length() == 1) {
            return 1;
        }

        int splitStringCount = 0;
        char firstAlphabet = ' ';
        int firstAlphabetCount = 0;
        int differentAlphabetsCount = 0;

        for (int index = 0; index < string.length(); index += 1) {
            if (index == string.length() - 1) {
                splitStringCount += 1;
                break;
            }

            char alphabet = string.charAt(index);

            if (firstAlphabet == ' ') {
                firstAlphabet = alphabet;
                firstAlphabetCount += 1;
                continue;
            }

            if (alphabet == firstAlphabet) {
                firstAlphabetCount += 1;
                continue;
            }

            differentAlphabetsCount += 1;
            if (firstAlphabetCount == differentAlphabetsCount) {
                splitStringCount += 1;
                firstAlphabet = ' ';
                firstAlphabetCount = 0;
                differentAlphabetsCount = 0;
            }
        }

//        for (int index = 1; index < string.length(); index += 1) {
//            if (index == string.length() - 1) {
//                splitStringCount += 1;
//                break;
//            }
//
//            char alphabet = string.charAt(index);
//            if (alphabet == firstCharacter) {
//                firstAlphabetCount += 1;
//                continue;
//            }
//
//            differentAlphabetsCount += 1;
//            if (firstAlphabetCount == differentAlphabetsCount) {
//                splitStringCount += 1;
//                if (index < string.length() - 1) {
//                    index += 1;
//                    firstAlphabet = string.charAt(index);
//                    firstAlphabetCount = 1;
//                    differentAlphabetsCount = 0;
//                }
//            }
//        }

        return splitStringCount;
    }
}
