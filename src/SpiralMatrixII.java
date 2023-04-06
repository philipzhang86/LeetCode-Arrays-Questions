import java.util.Arrays;
import java.util.LinkedList;

public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i<=n*n; i++){
            list.add(i);
        }
        filledInRecursive(list,result,0, result.length-1, 0,result[0].length-1);

        return result;
    }

    public static void filledIn(LinkedList<Integer> list, int[][] array){
        int startRow = 0;
        int endRow = array.length-1;
        int startCol = 0;
        int endCol = array[0].length-1;

        while (startRow<=endRow && startCol<= endCol){
            for(int col = startCol; col<=endCol; col++){
                array[startRow][col] = list.pollFirst();
            }

            for(int row = startRow+1; row<=endRow; row++){
                array[row][endCol] = list.pollFirst();
            }

            for(int col = endCol-1; col>=startCol; col--){
                if(startRow==endRow) break;
                array[endRow][col] = list.pollFirst();
            }

            for(int row = endRow-1; row>startRow; row--){
                if(startCol==endCol) break;
                array[row][startCol] = list.pollFirst();
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }

    private static void filledInRecursive(
            LinkedList<Integer> list,
            int[][] array,
            int startRow,
            int endRow,
            int startCol,
            int endCol){
        if(startRow > endRow || startCol > endCol)    return;

        for(int col = startCol; col<=endCol; col++){
            array[startRow][col] = list.pollFirst();
        }

        for(int row = startRow+1; row<=endRow; row++){
            array[row][endCol] = list.pollFirst();
        }

        for(int col = endCol-1; col>=startCol; col--){
            if(startRow==endRow) break;
            array[endRow][col] = list.pollFirst();
        }

        for(int row = endRow-1; row>startRow; row--){
            if(startCol==endCol) break;
            array[row][startCol] = list.pollFirst();
        }

        filledInRecursive(list,array,startRow+1,endRow-1,startCol+1,endCol-1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
