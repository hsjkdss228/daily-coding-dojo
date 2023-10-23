import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cache {
    public int solution(int limitCacheSize, String[] cities) {
        if (limitCacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;

        List<String> cache = new LinkedList<>();

        for (String element : cities) {
            String city = element.toLowerCase();

            if (cache.remove(city)) {
                answer += 1;
                cache.add(city);
                continue;
            }

            if (!cache.remove(city) && cache.size() >= limitCacheSize) {
                answer += 5;
                cache.remove(0);
                cache.add(city);
                continue;
            }

            // if (!cache.remove(city) && cache.size < limitCacheSize)
            answer += 5;
            cache.add(city);
        }

        return answer;
    }

//    public int solution(int limitCacheSize, String[] cities) {
//        int answer = 0;
//        Map<String, Integer> cache = new HashMap<>();
//
//        for (String element : cities) {
//            String city = element.toLowerCase();
//
//            if (limitCacheSize == 0) {
//                answer += 5;
//                continue;
//            }
//
//            // cache에 도시가 있는 경우
//            if (checkCacheIfContainsCity(cache, city)) {
//                answer += 1;
//                addMissCountForAllCities(cache);
//                cache.replace(city, 0);
//                continue;
//            }
//
//            // cache에 도시가 없는 경우
//            answer += 5;
//            if (cache.size() > limitCacheSize) {
//                String oldest = findTheOldest(cache);
//                cache.remove(oldest);
//            }
//            addMissCountForAllCities(cache);
//            cache.put(city, 0);
//        }
//
//        return answer;
//    }
//
//    public boolean checkCacheIfContainsCity(Map<String, Integer> cache,
//                                            String city) {
//        return cache.containsKey(city);
//    }
//
//    public void addMissCountForAllCities(Map<String, Integer> cache) {
//        cache.replaceAll((insertedCity, missCount) -> missCount + 1);
//    }
//
//    public String findTheOldest(Map<String, Integer> cache) {
//        Map.Entry<String, Integer> oldest
//            = Collections.max(cache.entrySet(), Map.Entry.comparingByValue());
//        return oldest.getKey();
//    }
}
