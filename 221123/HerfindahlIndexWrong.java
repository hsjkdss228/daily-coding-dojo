import java.util.Arrays;
import java.util.Collections;

public class HerfindahlIndexWrong {
    public int solution(int[] citations) {
        Integer[] citationsDescending = sort(citations);

        for (Integer citation : citationsDescending) {
            long count = countNumberOfCitation(citationsDescending, citation);

            if (count == citation) {
                return citation;
            }

            long sameNumberOfCitation
                = countSameNumberOfCitation(citationsDescending, citation);

//            System.out.println("citation: " + citation);
//            System.out.println("count: " + count);
//            System.out.println("count - sameNumberOfCitation - 1: "
//                + (count - sameNumberOfCitation - 1));

            if (count > citation
                && count - sameNumberOfCitation - 1 == 1) {
                return citation;
            }
        }

        return 0;
    }

    public long countSameNumberOfCitation(Integer[] citationsDescending,
                                          Integer citation) {
        return Arrays.stream(citationsDescending)
            .filter(found -> found.equals(citation))
            .count();
    }

    public long countNumberOfCitation(Integer[] citationsDescending,
                                      Integer citation) {
        return Arrays.stream(citationsDescending)
            .filter(found -> found >= citation)
            .count();
    }

    public Integer[] sort(int[] citations) {
        Integer[] boxed = Arrays.stream(citations)
            .boxed()
            .toArray(Integer[]::new);
        Arrays.sort(boxed, Collections.reverseOrder());
        return boxed;
    }
}
