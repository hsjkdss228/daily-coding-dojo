public class PaperCutting {
    public int solution(int width, int height) {
        int vertical = width - 1;
        int horizontal = (height - 1) * width;
        return vertical + horizontal;
    }
}
