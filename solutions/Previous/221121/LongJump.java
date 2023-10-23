public class LongJump {
    public long solution(int n) {
        int[] cases = new int[2001];

        cases[1] = 1;
        cases[2] = 2;
        for (int i = 3; i <= 2000; i += 1) {
            cases[i] = (cases[i - 2] + cases[i - 1]) % 1234567;
        }

        return cases[n];
    }
}
