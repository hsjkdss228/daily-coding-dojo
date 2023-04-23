import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class RoomHiringWrongTest {
    private RoomHiringWrong test;

    @BeforeEach
    void setUp() {
        test = new RoomHiringWrong();
    }

    @Test
    void localTimeEquals() {
        assertThat(LocalTime.of(10, 30)).isEqualTo(LocalTime.of(10, 30));
    }

    @Test
    void startTimeIsEarlierThanOtherEndTime() {
        RoomHiringWrong.Booking booking1 = RoomHiringWrong.Booking.of(
            LocalTime.of(14, 10),
            LocalTime.of(19, 30)
        );
        RoomHiringWrong.Booking booking2 = RoomHiringWrong.Booking.of(
            LocalTime.of(14, 30),
            LocalTime.of(20, 30)
        );
        assertThat(booking1.overlapped(booking2)).isTrue();
    }

    @Test
    void startTimeIsNotEarlierThanOtherEndTime() {
        RoomHiringWrong.Booking booking1 = RoomHiringWrong.Booking.of(
            LocalTime.of(14, 10),
            LocalTime.of(19, 30)
        );
        RoomHiringWrong.Booking booking2 = RoomHiringWrong.Booking.of(
            LocalTime.of(12, 0),
            LocalTime.of(14, 10)
        );
        assertThat(booking1.overlapped(booking2)).isFalse();
    }

    @Test
    void includesStartAndEndTime1() {
        RoomHiringWrong.Booking booking1 = RoomHiringWrong.Booking.of(
            LocalTime.of(14, 10),
            LocalTime.of(19, 30)
        );
        RoomHiringWrong.Booking booking2 = RoomHiringWrong.Booking.of(
            LocalTime.of(14, 20),
            LocalTime.of(15, 30)
        );
        assertThat(booking1.overlapped(booking2)).isTrue();
    }

    @Test
    void includesStartAndEndTime2() {
        RoomHiringWrong.Booking booking1 = RoomHiringWrong.Booking.of(
            LocalTime.of(14, 20),
            LocalTime.of(15, 30)
        );
        RoomHiringWrong.Booking booking2 = RoomHiringWrong.Booking.of(
            LocalTime.of(11, 10),
            LocalTime.of(22, 30)
        );
        assertThat(booking1.overlapped(booking2)).isTrue();
    }

    @Test
    void endTimeIsLaterThanOtherStartTime() {
        RoomHiringWrong.Booking booking1 = RoomHiringWrong.Booking.of(
            LocalTime.of(14, 10),
            LocalTime.of(19, 30)
        );
        RoomHiringWrong.Booking booking2 = RoomHiringWrong.Booking.of(
            LocalTime.of(19, 0),
            LocalTime.of(20, 30)
        );
        assertThat(booking1.overlapped(booking2)).isTrue();
    }

    @Test
    void isNotOverlapped() {
        RoomHiringWrong.Booking booking1 = RoomHiringWrong.Booking.of(
            LocalTime.of(15, 0),
            LocalTime.of(17, 10)
        );
        RoomHiringWrong.Booking booking2 = RoomHiringWrong.Booking.of(
            LocalTime.of(18, 20),
            LocalTime.of(21, 30)
        );
        assertThat(booking1.overlapped(booking2)).isFalse();
    }

    @Test
    void solution1() {
        String[][] bookedTime = {
            {"15:00", "17:00"},
            {"16:40", "18:20"},
            {"14:20", "15:20"},
            {"14:10", "19:20"},
            {"18:20", "21:20"}
        };
        assertThat(test.solution(bookedTime)).isEqualTo(3);
    }

    @Test
    void solution2() {
        String[][] bookedTime = {
            {"09:10", "10:10"},
            {"10:20", "12:20"},
        };
        assertThat(test.solution(bookedTime)).isEqualTo(1);
    }

    @Test
    void solution3() {
        String[][] bookedTime = {
            {"10:20", "12:30"},
            {"10:20", "12:30"},
            {"10:20", "12:30"}
        };
        assertThat(test.solution(bookedTime)).isEqualTo(3);
    }

    @Test
    void solution4() {
        String[][] bookedTime = {
            {"10:00", "10:40"},
            {"10:40", "11:20"},
            {"11:30", "11:50"},
            {"10:20", "10:40"},
            {"11:30", "11:50"},
            {"10:00", "10:10"},
            {"10:50", "11:00"},
            {"11:30", "11:50"},
            {"11:10", "11:20"},
            {"10:00", "10:30"},
            {"10:50", "11:20"},
            {"10:00", "11:20"},
            {"11:30", "11:50"}
        };
        assertThat(test.solution(bookedTime)).isEqualTo(4);
    }

    @Test
    void solution5() {
        String[][] bookedTime = {
            {"10:00", "11:00"},
            {"10:00", "11:00"},
            {"10:00", "11:00"},
            {"10:00", "11:00"},
            {"11:10", "13:20"},
            {"11:30", "12:00"},
            {"12:00", "14:00"},
            {"12:30", "16:00"},
            {"13:30", "13:50"},
            {"14:00", "15:00"}
        };
        assertThat(test.solution(bookedTime)).isEqualTo(4);
    }
}
