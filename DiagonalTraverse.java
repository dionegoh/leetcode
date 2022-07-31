import java.util.*;

class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int noOfRows = mat.length;
        int noOfCols = (mat[0]).length;
        
        int noOfElements = noOfRows * noOfCols;
        int noOfDiagonals = noOfRows + noOfCols - 1;
        
        int[] result = new int[noOfElements];
        int counter = 0; 
        int[][] diagonals = new int[noOfDiagonals][];
        
        
        for (int i = 0; i < noOfDiagonals; i++) {
            ArrayList<Integer> arrList = new ArrayList<>();
            
            int m, n;
            
            if (i < noOfCols) {
                m = 0;
                n = i;
            } else {
                m = i - noOfCols + 1; 
                n = noOfCols - 1;
            }
            
            while ((m < noOfRows) && (n >= 0)) {
                arrList.add(mat[m][n]); 
                m++; 
                n--; 
            }
            
            int[] diagonal = arrList.stream().mapToInt(z -> z).toArray();
            diagonals[i] = diagonal;
        }
        
        for (int i = 0; i < noOfDiagonals; i++) {
            int[] diagonal = diagonals[i];
            int diagonal_len = diagonal.length;
            
            if (i % 2 != 0) { //diagonal down
                for (int j = 0; j < diagonal_len; j++) {
                    result[counter] = diagonal[j];
                    counter ++;
                }
                
            } else {  //diagonal up
                for (int j = diagonal_len - 1; j >= 0; j--) {
                    result[counter] = diagonal[j];
                    counter ++;
                }
            }
        }
        
        return result;
    }
}