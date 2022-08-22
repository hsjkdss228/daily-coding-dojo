import java.util.Arrays;

public class KthNumber {
  public int[] solution(int[] array, int[][] commands) {
//    for (int j = 0; j < array.length; j += 1) {
//      System.out.print(array[j] + " ");
//    }
//    System.out.println();

//    for (int i = 0; i < commands.length; i += 1) {
//      for (int j = 0; j < commands[i].length; j += 1) {
//        System.out.print(commands[i][j] + " ");
//      }
//      System.out.println();
//    }
//    System.out.println();

    int[] answer = new int[commands.length];

//    System.out.println("answer.length: " + answer.length);

    for (int i = 0; i < commands.length; i += 1) {
//      System.out.println("i: " + i);

      int[] subArray
          = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

//      System.out.println("subArray: ");
//      for (int j = 0; j < subArray.length; j += 1) {
//        System.out.print(subArray[j] + "  ");
//      }
//      System.out.println();

      Arrays.sort(subArray);

//      System.out.println("sorted subArray: ");
//      for (int j = 0; j < subArray.length; j += 1) {
//        System.out.print(subArray[j] + " ");
//      }
//      System.out.println();

      int index = commands[i][2] - 1;
//      System.out.println("index: " + index);
//      System.out.println("subArray[" + index + "]: " + subArray[index]);

      answer[i] = subArray[index];

//      System.out.println();
//      System.out.println();
    }

    return answer;
  }
}

// Arrays.copyOfRange의 범위가 어떻게 정해지는지 파악하고,
// 문제를 잘 읽어서 범위를 잘 맞춰서 인자로 줘야 할 것 같다.
