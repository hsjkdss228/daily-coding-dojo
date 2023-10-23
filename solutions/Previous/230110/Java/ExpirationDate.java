import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpirationDate {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayAbsoluteDate = parseDate(today);

        Map<String, Integer> termsTypeAndAbsoluteDate = convertToMap(terms);
        List<Integer> answerIndices = new ArrayList<>();

        for (int i = 0; i < privacies.length; i += 1) {
            if (isExpired(
                privacies[i],
                todayAbsoluteDate,
                termsTypeAndAbsoluteDate)) {
                answerIndices.add(i + 1);
            }
        }

        return answerIndices.stream()
            .mapToInt(index -> index)
            .toArray();
    }

    public int parseDate(String today) {
        String[] yearMonthDay = today.split("\\.");
        return Integer.parseInt(yearMonthDay[0]) * 12 * 28
            + Integer.parseInt(yearMonthDay[1]) * 28
            + Integer.parseInt(yearMonthDay[2]);
    }

    public Map<String, Integer> convertToMap(String[] terms) {
        return Arrays.stream(terms)
            .collect(
                Collectors.toMap(
                    term -> term.split(" ")[0],
                    term -> Integer.parseInt(term.split(" ")[1]) * 28
                )
            );
    }

    public boolean isExpired(String privacy,
                             int todayAbsoluteDate,
                             Map<String, Integer> termsTypeAndAbsoluteDate) {
        String[] dateAndPrivacyType = privacy.split(" ");

        String privacyType = dateAndPrivacyType[1];

        int expirationAbsoluteDate
            = termsTypeAndAbsoluteDate.get(privacyType);

        String date = dateAndPrivacyType[0];
        int dateAbsolute = parseDate(date);

        int difference = todayAbsoluteDate - dateAbsolute;

        return difference >= expirationAbsoluteDate;
    }
}
