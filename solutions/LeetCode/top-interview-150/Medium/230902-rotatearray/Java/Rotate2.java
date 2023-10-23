public class Rotate2 {
    public void rotate(int[] numbers, int times) {
        reverse(numbers, 0, numbers.length - 1);
        reverse(numbers, 0, (times % numbers.length) - 1);
        reverse(numbers, times % numbers.length, numbers.length - 1);
    }

    public void reverse(int[] numbers, int left, int right) {
        while (left < right) {
            int temp = numbers[right];
            numbers[right] = numbers[left];
            numbers[left] = temp;
            left += 1;
            right -= 1;
        }
    }
}
