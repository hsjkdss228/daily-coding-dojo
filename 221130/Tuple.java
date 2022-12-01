import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tuple {
    public int[] solution(String sets) {
        List<String[]> sortedSets = setUp(sets);

        return makeTuple(sortedSets);
    }

    public List<String[]> setUp(String sets) {
        sets = sets.substring(2, sets.length() - 2);
        sets = sets.replace("},{", "/");
        String[] sortedSets = sets.split("/");

        Arrays.sort(sortedSets,
            Comparator.comparingInt(String::length));

        List<String[]> sortedSetsList = new ArrayList<>();
        for (String set : sortedSets) {
            sortedSetsList.add(set.split(","));
        }

        return sortedSetsList;
    }

    public int[] makeTuple(List<String[]> sortedSets) {
        int[] answer = new int[sortedSets.get(sortedSets.size() - 1).length];
        List<Integer> answerList = new ArrayList<>();

        int index = 0;
        for (String[] sortedSet : sortedSets) {
            for (String element : sortedSet) {
                int temp = Integer.parseInt(element);
                if (!answerList.contains(temp)) {
                    answerList.add(temp);
                    answer[index] = temp;
                    index += 1;
                }
            }
        }

        return answer;
    }
}

//    public List<List<Integer>> setUp(String sets) {
//        List<List<Integer>> converted = new ArrayList<>();
//        int index = 0;
//
//        while (index < sets.length()) {
//            List<Integer> set = new ArrayList<>();
//            int number = 0;
//
//            String now = String.valueOf(sets.charAt(index));
//            if (now.equals(",")) {
//                System.out.println("now: " + now);
//                index += 1;
//                continue;
//            }
//
//            while (!now.equals("}")) {
//                System.out.println("index: " + index);
//
//                now = String.valueOf(sets.charAt(index));
//                System.out.println("now: " + now);
//
//                if (now.equals("{")) {
//                    index += 1;
//                    continue;
//                }
//
//                if (now.equals(",")) {
//                    System.out.println("number: " + number);
//                    set.add(number);
//                    number = 0;
//                    index += 1;
//                    continue;
//                }
//
//                number += (number * 10)
//                    + Character.getNumericValue(sets.charAt(index));
//                index += 1;
//            }
//
//            converted.add(set);
//        }
//        return converted;
//    }
