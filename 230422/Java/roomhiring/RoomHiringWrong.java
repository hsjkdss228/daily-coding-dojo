import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class RoomHiringWrong {
    public static class Room {
        private final List<Booking> bookings = new ArrayList<>();

        public static Room create() {
            return new Room();
        }

        public int recentEndTime() {
            return bookings.isEmpty()
                ? 0
                : bookings.get(bookings.size() - 1).absoluteEndTime();
        }

        public boolean canBeBooked(Booking created) {
            for (Booking booking : bookings) {
                if (booking.overlapped(created)) {
                    return false;
                }
            }
            return true;
        }

        public void add(Booking created) {
            bookings.add(created);
        }
    }

    public static class Booking {
        private final LocalTime startTime;
        private final LocalTime endTime;

        public Booking(LocalTime startTime, LocalTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public static Booking of(LocalTime startTime, LocalTime endTime) {
            return new Booking(startTime, endTime);
        }

        public static Booking create(String startTimeString,
                                     String endTimeString) {
            LocalTime startTime = createLocalTime(startTimeString);
            LocalTime endTime = createLocalTime(endTimeString).plusMinutes(10);
            return new Booking(startTime, endTime);
        }

        private static LocalTime createLocalTime(String timeString) {
            int[] startHourAndMinute = split(timeString);
            int startHour = startHourAndMinute[0];
            int startMinute = startHourAndMinute[1];
            return LocalTime.of(startHour, startMinute);
        }

        private static int[] split(String timeString) {
            return Arrays.stream(timeString.split(":"))
                .map(Integer::parseInt)
                .mapToInt(time -> time)
                .toArray();
        }

        private int absoluteTime(LocalTime localTime) {
            return (localTime.getHour() * 60) + localTime.getMinute();
        }

        public int absoluteStartTime() {
            return absoluteTime(startTime);
        }

        public int absoluteEndTime() {
            return absoluteTime(endTime);
        }

        public boolean overlapped(Booking other) {
            return (other.startTime.isBefore(this.startTime)
                    && other.endTime.isAfter(this.startTime))
                || (other.startTime.isBefore(this.endTime)
                    && other.endTime.isAfter(this.endTime))
                || ((other.startTime.isAfter(this.startTime)
                    || other.startTime.equals(this.startTime))
                    && (other.endTime.isBefore(this.endTime)
                    || other.endTime.equals(this.endTime)))
                || (other.startTime.isBefore(this.startTime)
                    && other.endTime.isAfter(this.endTime));
        }

        @Override
        public String toString() {
            return "Booking {" +
                "startTime=" + startTime + ", endTime=" + endTime + "}";
        }
    }

    public int solution(String[][] bookedTimes) {
        Comparator<Room> orderByRecentEndTime
            = Collections.reverseOrder(
            Comparator.comparing(Room::recentEndTime)
        );
        Queue<Room> rooms = new PriorityQueue<>(orderByRecentEndTime);
        List<Booking> bookings = convert(bookedTimes);
        sortOrderByStartTimeAndLength(bookings);

        for (Booking booking : bookings) {
            if (rooms.isEmpty()) {
                createNewRoomAndBook(rooms, booking);
                continue;
            }

            boolean notAdded = true;
            List<Room> searched = new ArrayList<>();
            while (!rooms.isEmpty()) {
                Room room = rooms.poll();
                searched.add(room);
                if (room.canBeBooked(booking)) {
                    room.add(booking);
                    notAdded = false;
                    break;
                }
            }
            rooms.addAll(searched);

            if (notAdded) {
                createNewRoomAndBook(rooms, booking);
            }
        }

        return rooms.size();
    }

    private List<Booking> convert(String[][] bookedTimes) {
        return Arrays.stream(bookedTimes)
            .map(this::createBooking)
            .collect(Collectors.toList());
    }

    private Booking createBooking(String[] bookedTime) {
        String startTime = bookedTime[0];
        String endTime = bookedTime[1];
        return Booking.create(startTime, endTime);
    }

    private void sortOrderByStartTimeAndLength(List<Booking> bookings) {
        bookings.sort(Comparator.comparing(Booking::absoluteStartTime)
            .thenComparing(Booking::absoluteEndTime));
    }

    private void createNewRoomAndBook(Queue<Room> rooms, Booking booking) {
        Room room = Room.create();
        room.add(booking);
        rooms.add(room);
    }
}
