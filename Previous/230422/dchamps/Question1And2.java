import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question1And2 {
    public static class Student {
        private final int score;
        private String grade;

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

        public void evaluate(String grade) {
            this.grade = grade;
        }
    }

    public static class Professor {
        public static void grade(List<Student> students,
                                 int[] limitIndexByScore) {
            List<Student> sortedStudents = students.stream()
                .sorted((previous, next) -> next.score() - previous.score())
                .collect(Collectors.toList());

            int aLimitIndex = limitIndexByScore[0];
            int bLimitIndex = limitIndexByScore[1];
            IntStream.range(0, sortedStudents.size())
                .forEach(order -> {
                    if (order <= aLimitIndex) {
                        sortedStudents.get(order).evaluate("A");
                        return;
                    }
                    if (order <= bLimitIndex) {
                        sortedStudents.get(order).evaluate("B");
                        return;
                    }
                    sortedStudents.get(order).evaluate("C");
                });
        }

        public static int[] calculateLimitIndexByScore(int count) {
            int aLimitIndex = calculateRateAndFloor(count, 30);
            int bLimitIndex = calculateRateAndFloor(count, 70);
            return new int[]{aLimitIndex, bLimitIndex};
        }

        private static int calculateRateAndFloor(double count, int rate) {
            return (int) Math.floor(count * rate / 100) - 1;
        }
    }

    public String solution(int count, int[] scores) {
        List<Student> students = Arrays.stream(scores)
            .mapToObj(Student::new)
            .collect(Collectors.toList());

        int[] limitIndexByScore = Professor.calculateLimitIndexByScore(count);
        Professor.grade(students, limitIndexByScore);

        return students.stream()
            .map(Student::grade)
            .collect(Collectors.joining());
    }
}
