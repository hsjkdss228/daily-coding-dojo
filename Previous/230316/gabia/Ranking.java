import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Ranking {
    public static class User {
        private final String nickname;
        private final int score;

        public User(String nickname, int score) {
            this.nickname = nickname;
            this.score = score;
        }

        public static User of(String userScore) {
            String[] nicknameAndScore = userScore.split(" ");
            return new User(
                nicknameAndScore[0],
                Integer.parseInt(nicknameAndScore[1])
            );
        }

        public String nickname() {
            return nickname;
        }

        public int score() {
            return score;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            User user = (User) other;
            return Objects.equals(nickname, user.nickname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nickname);
        }

        @Override
        public String toString() {
            return "User{" +
                "nickname='" + nickname + '\'' +
                ", score=" + score +
                '}';
        }
    }

    public int solution(int userCountToShow, String[] userScores) {
        List<User> page = new ArrayList<>();
        Set<User> usersInPage = new HashSet<>();

        int changedCount = 0;
        for (String userScore : userScores) {
            User user = User.of(userScore);

//            System.out.println("user: " + user);

            if (page.isEmpty()) {
                page.add(user);
                usersInPage.add(user);
                changedCount += 1;

//                System.out.print("page now: ");
//                page.forEach(rankedUser -> {
//                    System.out.print(rankedUser.nickname() + "/" + rankedUser.score + " ");
//                });
//                System.out.println();
//                System.out.println("changed count: " + changedCount);
//                System.out.println();

                continue;
            }

//            int score = user.score();
//            int scoreOfLast = page.get(page.size() - 1).score();
//            if (score <= scoreOfLast) {
////                System.out.println("마지막 유저보다도 작음");
////                System.out.println("changed count: " + changedCount);
////                System.out.println();
//                continue;
//            }

            int removedCurrentUserIndex = 0;
            if (usersInPage.contains(user)) {
                User currentUser = findUser(page, user);
//                System.out.println(user);
//                System.out.println(currentUser);
                if (user.score() <= currentUser.score()) {
//                    System.out.println("순위에 같은 유저가 이미 존재하는데 그 기록보다 작음");
//                    System.out.println("changed count: " + changedCount);
//                    System.out.println();
                    continue;
                }
                removedCurrentUserIndex = page.indexOf(currentUser);
                page.remove(currentUser);
                usersInPage.remove(currentUser);
//                System.out.println("순위에 같은 유저가 이미 존재했는데 그 기록보다 커서 기존의 유저 기록을 삭제");
//                System.out.print("page now: ");
//                page.forEach(rankedUser -> {
//                    System.out.print(rankedUser.nickname() + "/" + rankedUser.score + " ");
//                });
//                System.out.println();
            }

            for (int index = 0; index < page.size(); index += 1) {
                User rankedUser = page.get(index);
                if (user.score() > rankedUser.score()) {
                    page.add(index, user);
                    usersInPage.add(user);
                    changedCount += 1;
                    break;
                }
                if (user.score() <= rankedUser.score()
                    && index == page.size() - 1
                    && page.size() < userCountToShow) {
                    page.add(index + 1, user);
                    usersInPage.add(user);

                    int userIndex = page.indexOf(user);
                    if (userIndex != removedCurrentUserIndex) {
                        changedCount += 1;
                    }
                    break;
                }
            }

            if (page.size() > userCountToShow) {
                User removed = page.remove(page.size() - 1);
                usersInPage.remove(removed);
            }

//            System.out.print("page now: ");
//            page.forEach(rankedUser -> {
//                System.out.print(rankedUser.nickname() + "/" + rankedUser.score + " ");
//            });
//            System.out.println();
//            System.out.println("changed count: " + changedCount);
//            System.out.println();
        }

        return changedCount;
    }

    public User findUser(List<User> page, User user) {
        for (User rankedUser : page) {
            if (rankedUser.nickname().equals(user.nickname())) {
                return rankedUser;
            }
        }
        return null;
    }
}





















