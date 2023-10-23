import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question3 {
    public static class Student {
        private final int score;
        private String grade;
        private double percentileRank;

        public Student(int score) {
            this.score = score;
            this.grade = null;
        }

        public int score() {
            return score;
        }

        public String grade() {
            return grade;
        }

        public void calculatePercentileRank(int index, int count) {
            double order = index + 1;
            percentileRank = order / count * 100;
        }

        public void evaluate(String grade) {
            this.grade = grade;
        }

        public double percentileRank() {
            return percentileRank;
        }

        public void replacePercentileRank(double lastPercentileRank) {
            this.percentileRank = lastPercentileRank;
        }
    }

    public static class Professor {
        public static void grade(List<Student> students,
                                 double[] percentileByGrade) {
            Map<Integer, List<Student>> scoreAndStudents
                = createScoreAndStudents(students);
            List<Student> sortedStudents = students.stream()
                .sorted((previous, next) -> next.score() - previous.score())
                .collect(Collectors.toList());
            calculatePercentileRank(sortedStudents);
            scoreAndStudents.forEach((score, studentsWithScore) -> {
                List<Student> sortedStudentsWithPercentileRank = studentsWithScore.stream()
                    .sorted((previous, next) -> (int) ((next.percentileRank() * 100) - (previous.percentileRank() * 100)))
                    .collect(Collectors.toList());
                double lastPercentileRank = sortedStudentsWithPercentileRank.get(0)
                    .percentileRank();
                studentsWithScore.forEach(student -> {
                    student.replacePercentileRank(lastPercentileRank);
                });
            });

            double aLimitPercentile = percentileByGrade[0];
            double bLimitPercentile = percentileByGrade[1];
            IntStream.range(0, sortedStudents.size())
                .forEach(index -> {
                    Student student = sortedStudents.get(index);
                    double percentileRank = student.percentileRank();
                    if (percentileRank <= aLimitPercentile) {
                        sortedStudents.get(index).evaluate("A");
                        return;
                    }
                    if (percentileRank <= bLimitPercentile) {
                        sortedStudents.get(index).evaluate("B");
                        return;
                    }
                    sortedStudents.get(index).evaluate("C");
                });
        }

        private static Map<Integer, List<Student>> createScoreAndStudents(
            List<Student> students
        ) {
            Map<Integer, List<Student>> scoreAndStudents = new HashMap<>();
            for (Student student : students) {
                int score = student.score();
                if (scoreAndStudents.containsKey(score)) {
                    scoreAndStudents.get(score).add(student);
                    continue;
                }
                List<Student> studentsWithScore = new ArrayList<>();
                studentsWithScore.add(student);
                scoreAndStudents.put(score, studentsWithScore);
            }
            return scoreAndStudents;
        }

        private static void calculatePercentileRank(List<Student> sortedStudents) {
            IntStream.range(0, sortedStudents.size())
                .forEach(index -> {
                    sortedStudents.get(index)
                        .calculatePercentileRank(index, sortedStudents.size());
                });
        }
    }

    public String solution(int count, int[] scores) {
        List<Student> students = Arrays.stream(scores)
            .mapToObj(Student::new)
            .collect(Collectors.toList());

        double[] percentileByGrade = {30, 70};
        Professor.grade(students, percentileByGrade);

        return students.stream()
            .map(Student::grade)
            .collect(Collectors.joining());
    }
}
