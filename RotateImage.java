
import java.util.ArrayList;

public class RotateImage {
    public void rotate(int[][] matrix) {
        //first col becomes first row 
        //second col becomes second row etc
        int len = matrix.length;
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            ArrayList<Integer> newRow = new ArrayList<>();
            for (int j = len - 1; j >= 0; j--) {
                newRow.add(matrix[j][i]);
            }
            arrList.add(newRow);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = arrList.get(i).get(j);
            }
        }

    }
}
