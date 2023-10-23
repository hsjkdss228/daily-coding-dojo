import java.util.HashMap;
import java.util.Map;

public class PersonalityTypes {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> typeToScores = initTypeToScores();

        calculateTypeScores(typeToScores, survey, choices);

        return determinePersonalityType(typeToScores);
    }

    private Map<Character, Integer> initTypeToScores() {
        return new HashMap<>(Map.of(
            'R', 0, 'T', 0,
            'C', 0, 'F', 0,
            'J', 0, 'M', 0,
            'A', 0, 'N', 0
        ));
    }

    private void calculateTypeScores(Map<Character, Integer> typeToScores,
                                     String[] survey,
                                     int[] choices) {
        for (int i = 0; i < survey.length; i += 1) {
            if (choices[i] >= 1 && choices[i] <= 3) {
                Character type = survey[i].charAt(0);
                typeToScores.put(
                    type,
                    typeToScores.get(type) + 4 - choices[i]
                );
                continue;
            }

            if (choices[i] >= 5 && choices[i] <= 7) {
                Character type = survey[i].charAt(1);
                typeToScores.put(
                    type,
                    typeToScores.get(type) + choices[i] - 4
                );
            }
        }
    }

    private String determinePersonalityType(Map<Character, Integer> typeToScores) {
        char firstType = typeToScores.get('R') >= typeToScores.get('T')
            ? 'R' : 'T';
        char secondType = typeToScores.get('C') >= typeToScores.get('F')
            ? 'C' : 'F';
        char thirdType = typeToScores.get('J') >= typeToScores.get('M')
            ? 'J' : 'M';
        char fourthType = typeToScores.get('A') >= typeToScores.get('N')
            ? 'A' : 'N';

        return "" + firstType +
            secondType +
            thirdType +
            fourthType;
    }
}
