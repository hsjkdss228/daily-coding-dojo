public class Parcel {
    public long solution(int capacity, int n, int[] deliveries, int[] pickups) {
        long distance = 0;

        for (int index = n - 1; index >= 0; index -= 1) {
            if (deliveries[index] <= 0 && pickups[index] <= 0) {
                continue;
            }

            distance += (index + 1) * 2L;

            boolean deliveriesRemains = ship(capacity, index, deliveries);
            boolean pickupsRemains = ship(capacity, index, pickups);

            if (deliveriesRemains || pickupsRemains) {
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

    public boolean ship(int capacity, int startIndex, int[] shipments) {
        int index = startIndex;

        boolean remains = false;

        while (capacity > 0) {
            if (index < 0) {
                break;
            }

            if (shipments[index] > 0) {
                int valueToSubtract = Math.min(shipments[index], capacity);
                shipments[index] = Math.max(shipments[index] - valueToSubtract, 0);
                capacity -= valueToSubtract;
            }

            if (shipments[index] > 0) {
                remains = true;
            }

            index -= 1;
        }

        return remains;
    }
}
