import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingFeeTest {
    @Test
    void solution() {
        ParkingFee test = new ParkingFee();

        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"
        };
        int[] result = new int[]{14600, 34400, 5000};
        assertThat(test.solution(fees, records)).isEqualTo(result);
    }
}
