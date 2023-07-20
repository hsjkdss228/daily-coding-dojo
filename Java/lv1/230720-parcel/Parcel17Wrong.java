public class Parcel17Wrong {
    public long solution(int capacity, int n, int[] deliveries, int[] pickups) {
        long distance = 0;

        for (int index = n - 1; index >= 0; index -= 1) {
            if (deliveries[index] <= 0 && pickups[index] <= 0) {
                continue;
            }

            distance += (index + 1) * 2L;

            boolean remains = deliverAndPickup(capacity, index, deliveries, pickups);

            if (remains) {
                index += 1;
            }

//            System.out.println("startIndex: " + index);
//            System.out.println("deliveries: " + Arrays.stream(deliveries).boxed().toList());
//            System.out.println("pickups: " + Arrays.stream(pickups).boxed().toList());
//            System.out.println("distance: " + distance);
//            System.out.println();
        }

        return distance;
    }

    public boolean deliverAndPickup(int capacity, int startIndex, int[] deliveries, int[] pickups) {
        int deliveryCapacity = capacity;
        int pickupCapacity = capacity;
        int index = startIndex;

        boolean remains = false;

        while (deliveryCapacity > 0 || pickupCapacity > 0) {
            if (index < 0) {
                break;
            }

            if (deliveries[index] > 0) {
                int valueToSubtract = Math.min(deliveries[index], deliveryCapacity);
                deliveries[index] = Math.max(deliveries[index] - valueToSubtract, 0);
                deliveryCapacity -= valueToSubtract;
            }

            if (pickups[index] > 0) {
                int valueToSubtract = Math.min(pickups[index], pickupCapacity);
                pickups[index] = Math.max(pickups[index] - valueToSubtract, 0);
                pickupCapacity -= valueToSubtract;
            }

            if (deliveries[index] > 0 || pickups[index] > 0) {
                remains = true;
            }

            index -= 1;
        }

        return remains;
    }
}
