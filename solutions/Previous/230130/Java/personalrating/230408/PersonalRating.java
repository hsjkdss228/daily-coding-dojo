import java.util.Objects;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.stream.IntStream;

public class PersonalRating {
    public static class Score {
        private final int workAttitude;
        private final int peerEvaluation;

        public Score(int workAttitude, int peerEvaluation) {
            this.workAttitude = workAttitude;
            this.peerEvaluation = peerEvaluation;
        }

        public static Score of(int workAttitude, int peerEvaluation) {
            return new Score(workAttitude, peerEvaluation);
        }

        public int sum() {
            return workAttitude + peerEvaluation;
        }

        public boolean hasBiggerSumThan(Score next) {
            return this.sum() > next.sum();
        }

        public boolean hasSmallerSumThan(Score previous) {
            return this.sum() < previous.sum();
        }

        public boolean bothAreLowerThan(Score next) {
            return this.workAttitude < next.workAttitude
                && this.peerEvaluation < next.peerEvaluation;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            Score score = (Score) other;
            return workAttitude == score.workAttitude
                && peerEvaluation == score.peerEvaluation;
        }

        @Override
        public int hashCode() {
            return Objects.hash(workAttitude, peerEvaluation);
        }

        @Override
        public String toString() {
            return "Score{" +
                "workAttitude=" + workAttitude +
                ", peerEvaluation=" + peerEvaluation +
                '}';
        }
    }

    public int solution(int[][] rawScores) {
        Score myScore = getMyScore(rawScores[0]);

        List<Score> scores = createScores(rawScores, myScore);
        sortScores(scores);
//        List<Score> scores = createSortedScores(rawScores, myScore);
        excludeIfConditionNotMet(scores);

        if (excluded(scores, myScore)) {
            return -1;
        }
        if (noDuplicateRatings(scores, myScore)) {
            return scores.indexOf(myScore) + 1;
        }
        return calculateDuplicateRatings(scores, myScore);
    }

    public Score getMyScore(int[] myScore) {
        int myWorkAttitude = myScore[0];
        int myPeerEvaluation = myScore[1];
        return new Score(myWorkAttitude, myPeerEvaluation);
    }

    public List<Score> createScores(int[][] rawScores, Score myScore) {
        // 완호보다 점수가 높은 사원만 List에 넣는 로직
        List<Score> scores = new ArrayList<>();
        addScoresExceptLowerThanMyScore(scores, rawScores, myScore);
        return scores;

        // 모든 사원의 점수를 List에 넣는 로직
//        return Arrays.stream(scores)
//            .map(score -> {
//                int workAttitude = score[0];
//                int peerEvaluation = score[1];
//                return new Score(workAttitude, peerEvaluation);
//            })
//            .collect(Collectors.toList());
    }

    // 처음에 PriorityQueue에 정렬하면서 점수를 넣고, List로 변환하는 로직
    // 실패: PQ의 성질을 만족하게만 정렬되고, '완전한' 오름차순이나 내림차순으로 정렬되지 않음
    public List<Score> createSortedScores(int[][] rawScores, Score myScore) {
        Comparator<Score> comparator
            = (previous, next) -> next.sum() - previous.sum();
        Queue<Score> sortedScores = new PriorityQueue<>(comparator);

        addScoresExceptLowerThanMyScore(sortedScores, rawScores, myScore);
        return new ArrayList<>(sortedScores);
    }

    public void addScoresExceptLowerThanMyScore(Collection<Score> scores,
                                                int[][] rawScores,
                                                Score myScore) {
        scores.add(myScore);
        IntStream.range(1, rawScores.length)
            .forEach(index -> {
                int workAttitude = rawScores[index][0];
                int peerEvaluation = rawScores[index][1];
                Score score = new Score(workAttitude, peerEvaluation);
                if (!myScore.hasBiggerSumThan(score)) {
                    scores.add(score);
                }
            });
    }

    public void sortScores(List<Score> scores) {
        scores.sort((previous, next) -> next.sum() - previous.sum());
    }

    public void excludeIfConditionNotMet(List<Score> scores) {
        for (int i = scores.size() - 1; i >= 0; i -= 1) {
            Score score = scores.get(i);
            for (int j = i - 1; j >= 0; j -= 1) {
                Score previous = scores.get(j);
                if (score.bothAreLowerThan(previous)) {
                    scores.remove(score);
                    break;
                }
            }
        }
    }

    public boolean excluded(List<Score> scores, Score myScore) {
        return !scores.contains(myScore);
    }

    public boolean noDuplicateRatings(List<Score> scores, Score myScore) {
        if (scores.size() == 1) {
            return true;
        }

        int myIndex = scores.indexOf(myScore);
        Score next = myIndex == scores.size() - 1
            ? null
            : scores.get(myIndex + 1);
        Score previous = myIndex == 0
            ? null
            : scores.get(myIndex - 1);

        if (next != null && previous == null) {
            return myScore.hasBiggerSumThan(next);
        }
        if (previous != null && next == null) {
            return myScore.hasSmallerSumThan(previous);
        }
        return myScore.hasBiggerSumThan(next)
            && myScore.hasSmallerSumThan(previous);
    }

    public int calculateDuplicateRatings(List<Score> scores, Score myScore) {
        int myIndex = scores.indexOf(myScore);

        if (myIndex == 0) {
            return myIndex + 1;
        }
        for (int i = myIndex; i >= 0; i -= 1) {
            Score previous = scores.get(i);
            if (myScore.hasSmallerSumThan(previous)) {
                int previousIndex = scores.indexOf(previous);
                return previousIndex + 2;
            }
        }
        return 1;
    }
}
