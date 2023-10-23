import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static class Advertisement {
        private String id;
        private int viewingPrice;
        private int clickingPrice;
        private int viewingCount;
        private int clickingCount;
        private Integer totalPrice;

        public Advertisement(String id, String viewingPrice, String clickingPrice) {
            this.id = id;
            this.viewingPrice = Integer.parseInt(viewingPrice);
            this.clickingPrice = Integer.parseInt(clickingPrice);
            this.viewingCount = 0;
            this.clickingCount = 0;
            this.totalPrice = null;
        }

        public String id() {
            return id;
        }

        public Integer totalPrice() {
            return totalPrice;
        };

        public void addViewingCount() {
            this.viewingCount += 1;
        }

        public void addClickingCount() {
            this.clickingCount += 1;
        }

        public void calculateTotalPrice() {
            this.totalPrice = (viewingPrice * viewingCount) + (clickingPrice * clickingCount);
        }
    }

    public String solution(String[][] adInfos, String[][] logs) {
        Map<String, Advertisement> advertisements = createAdvertisements(adInfos);
        calculateCounts(advertisements, logs);
        calculateTotalPrices(advertisements);
        return findAdvertisementIdWithHighestTotalPrice(advertisements);
    }

    public Map<String, Advertisement> createAdvertisements(String[][] adInfos) {
        Map<String, Advertisement> advertisements = new HashMap<>();
        for (String[] adInfo : adInfos) {
            String id = adInfo[0];
            String viewingPrice = adInfo[1];
            String clickingPrice = adInfo[2];
            advertisements.put(id, new Advertisement(id, viewingPrice, clickingPrice));
        }
        return advertisements;
    }

    public void calculateCounts(Map<String, Advertisement> advertisements, String[][] logs) {
        for (String[] log : logs) {
            String id = log[1];
            String type = log[0];
            if (advertisements.containsKey(id) && isViewing(type)) {
                advertisements.get(id).addViewingCount();
                continue;
            }
            if (advertisements.containsKey(id) && isClicking(type)) {
                advertisements.get(id).addClickingCount();
            }
        }
    }

    public boolean isViewing(String type) {
        return type.equals("V");
    }

    public boolean isClicking(String type) {
        return type.equals("C");
    }

    public void calculateTotalPrices(Map<String, Advertisement> advertisements) {
        advertisements.forEach((id, advertisement) -> advertisement.calculateTotalPrice());
    }

    public String findAdvertisementIdWithHighestTotalPrice(Map<String, Advertisement> advertisements) {
        List<Advertisement> sortedAdvertisements = advertisements.values()
            .stream()
            .sorted((previous, next) -> next.totalPrice() - previous.totalPrice())
            .collect(Collectors.toList());
        int highestTotalPrice = sortedAdvertisements.get(0).totalPrice();
        int lowerTotalPrice = sortedAdvertisements.get(1).totalPrice();
        return highestTotalPrice == lowerTotalPrice
            ? "-1"
            : sortedAdvertisements.get(0).id();
    }
}
