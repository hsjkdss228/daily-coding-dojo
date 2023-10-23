import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CacheTest {
//    @Test
//    void checkCacheIfContainsCity() {
//        Cache test = new Cache();
//
//        Map<String, Integer> cache = new HashMap<>();
//        cache.put("seoul", 0);
//        cache.put("daejeon", 0);
//        cache.put("geumsan", 0);
//
//        String containedCity = "geumsan";
//        assertThat(test.checkCacheIfContainsCity(cache, containedCity))
//            .isTrue();
//
//        String notContainedCity = "gwangju";
//        assertThat(test.checkCacheIfContainsCity(cache, notContainedCity))
//            .isFalse();
//    }
//
//    @Test
//    void addMissCountForAllCities() {
//        Cache test = new Cache();
//
//        Map<String, Integer> cache = new HashMap<>();
//        cache.put("seoul", 2);
//        cache.put("daejeon", 1);
//        cache.put("geumsan", 0);
//
//        test.addMissCountForAllCities(cache);
//        assertThat(cache.get("seoul")).isEqualTo(3);
//        assertThat(cache.get("daejeon")).isEqualTo(2);
//        assertThat(cache.get("geumsan")).isEqualTo(1);
//    }
//
//    @Test
//    void findTheOldest() {
//        Cache test = new Cache();
//
//        Map<String, Integer> cache = new HashMap<>();
//        cache.put("seoul", 2);
//        cache.put("daejeon", 1);
//        cache.put("geumsan", 0);
//
//        assertThat(test.findTheOldest(cache)).isEqualTo("seoul");
//    }

    @Test
    void solution() {
        Cache test = new Cache();

        int cacheSizeCase1 = 3;
        String[] citiesCase1 = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork",
            "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assertThat(test.solution(cacheSizeCase1, citiesCase1)).isEqualTo(50);

        int cacheSizeCase2 = 5;
        String[] citiesCase2 = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork",
            "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        assertThat(test.solution(cacheSizeCase2, citiesCase2)).isEqualTo(52);

        int cacheSizeCase3 = 0;
        String[] citiesCase3 = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assertThat(test.solution(cacheSizeCase3, citiesCase3)).isEqualTo(25);
    }
}
