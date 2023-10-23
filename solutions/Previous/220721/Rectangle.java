import java.util.Scanner;

public class Rectangle {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int height = scanner.nextInt();
    int width = scanner.nextInt();

    for (int i = 0; i < height; i += 1) {
      for (int j = 0; j < width; j += 1) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
