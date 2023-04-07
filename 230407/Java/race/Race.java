import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Race {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerAndRankings = new HashMap<>();
        Map<Integer, String> rankingAndPlayers = new HashMap<>();

        IntStream.range(0, players.length)
            .forEach(ranking -> {
                String player = players[ranking];
                playerAndRankings.put(player, ranking);
                rankingAndPlayers.put(ranking, player);
            });

        Arrays.stream(callings)
            .forEach(called -> {
                int rankingCalled = playerAndRankings.get(called);
                String ahead = rankingAndPlayers.get(rankingCalled - 1);
                int rankingAhead = playerAndRankings.get(ahead);

                playerAndRankings.replace(ahead, rankingCalled);
                rankingAndPlayers.replace(rankingCalled, ahead);
                playerAndRankings.replace(called, rankingAhead);
                rankingAndPlayers.replace(rankingAhead, called);
            });

        return rankingAndPlayers.values()
            .toArray(String[]::new);

//        return playerAndRankings.entrySet()
//            .stream()
//            .sorted(Comparator.comparingInt(Map.Entry::getValue))
//            .map(Map.Entry::getKey)
//            .toArray(String[]::new);
    }
}
