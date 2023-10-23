public class MatrixPlus {
  public int[][] solution(int[][] array1, int[][] array2) {
    int[][] answer = new int[array1.length][array1[0].length];

    for (int i = 0; i < array1.length; i += 1) {
      for (int j = 0; j < array1[i].length; j += 1) {
        answer[i][j] = array1[i][j] + array2[i][j];
      }
    }

    return answer;
  }
}
