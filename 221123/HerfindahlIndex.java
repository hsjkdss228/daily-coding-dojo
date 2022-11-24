import java.util.Arrays;

public class HerfindahlIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;

        for (int i = 0; i < citations.length; i += 1) {
            int hIndex = citations.length - i;
            if (citations[i] >= hIndex) {
                answer = hIndex;
                break;
            }
        }

        return answer;
    }
}
