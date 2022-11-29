public class MatrixMultiplication {
    public int[][] solution(int[][] array1, int[][] array2) {
        int rowLength = array1.length;
        int columnLength = array2[0].length;
        int[][] answer = new int[rowLength][columnLength];

        for (int row = 0; row < array1.length; row += 1) {
            int element = 0;
            for (int column = 0; column < array2[0].length; column += 1) {
                for (int k = 0; k < array1[0].length; k += 1) {
//                    System.out.println("row: " + row);
//                    System.out.println("column: " + column);
//                    System.out.println("k: " + k);
//                    System.out.println("array1[" + row + "][" + k + "]: " + array1[row][k]);
//                    System.out.println("array2[" + k + "][" + column + "]: " + array2[k][column]);
                    answer[row][column] += array1[row][k] * array2[k][column];
                }
            }
//            System.out.println();
        }

//        for (int row = 0; row < array1.length; row += 1) {
//            for (int column = 0; column < array2[0].length; column += 1) {
//                System.out.print(answer[row][column]+ " ");
//            }
//            System.out.println();
//        }

        return answer;
    }
}
