import java.util.Arrays;

public class TheSmallestRectangles {
  public int solution(int[][] sizes) {
    int[] widths = new int[sizes.length];
    int[] heights = new int[sizes.length];

    for (int i = 0; i < sizes.length; i += 1) {
//      System.out.println(sizes[i][0] + ", " + sizes[i][1]);
//      System.out.println("max: " + Math.max(sizes[i][0], sizes[i][1]));
//      System.out.println("min: " + Math.min(sizes[i][0], sizes[i][1]));
//      System.out.println();

      widths[i] = Math.max(sizes[i][0], sizes[i][1]);
      heights[i] = Math.min(sizes[i][0], sizes[i][1]);
    }

    int maxWidth = Arrays.stream(widths).max().getAsInt();
    int maxHeight = Arrays.stream(heights).max().getAsInt();

//    System.out.println();
//    System.out.println(maxWidth + ", " + maxHeight);

    return maxWidth * maxHeight;
  }
}
