public class Password {
    public String solution(String string, String skip, int index) {
        String answer = "";

        for (int i = 0; i < string.length(); i += 1) {
            char alphabet = string.charAt(i);
            char convertedAlphabet = createAlphabet(alphabet, skip, index);
            answer += convertedAlphabet;
        }

        return answer;
    }

    public char createAlphabet(char alphabet, String skip, int index) {
        char convertedAlphabet = alphabet;

        for (int i = 0; i < index; i += 1) {
            convertedAlphabet += 1;

            if (convertedAlphabet > 'z') {
                convertedAlphabet = 'a';
            }

//            if (cannotCount(convertedAlphabet, skip)) {
            if (skip.contains(String.valueOf(convertedAlphabet))) {
                i -= 1;
                continue;
            }

//            System.out.println("i:" + i + ", alphabet now: " + convertedAlphabet);
        }

        return convertedAlphabet;
    }

//    public boolean cannotCount(char alphabet, String skip) {
//        for (int i = 0; i < skip.length(); i += 1) {
//            char alphabetToSkip = skip.charAt(i);
//            if (alphabet == alphabetToSkip) {
//                return true;
//            }
//        }
//        return false;
//    }
}
