import java.util.LinkedList;
import java.util.List;

/*
     →
  ↑    ↓
    ←
 */
public class SpiralTraverseEx1 {
    public static List<Integer> spiralTraverse(int[][] array) {
        int N = array.length;
        if(N == 0) return new LinkedList<Integer>();
        LinkedList<Integer> result = new LinkedList<>();

        int startRow = 0;
        int endRow = N-1;
        int startCol = 0;
        int endCol = array[0].length-1;

        while (startRow<=endRow && startCol<=endCol){
            for(int col = startCol; col<=endCol; col++){// top left-----top right 列            →
                result.add(array[startRow][col]);
            }

            for(int row = startRow+1; row<=endRow; row++){//right up ---- right down 行         ↓
                result.add(array[row][endCol]);
            }

            for(int col = endCol - 1; col>= startCol; col--){//bottom right --- bottom left 列  ←
                if(startRow ==endRow) break; //当 ↑ ↓ 重合, →就已经包晒，就不需要再 ←
                result.add(array[endRow][col]);
            }

            for(int row = endRow-1; row>startRow; row--){//left bottom --- left top 行          ↑
                if(startCol == endCol) break; //当 → ← 重合, ↓就已经包晒，就不需要再 ↑
                result.add(array[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4},
                {12,13,14,5},
                {11,16,15,6},
                {10, 9, 8,7}};

        int[][] array2 = {{1, 2, 3, 4},
                          {10,11,12,5},
                          {9, 8, 7, 6}};

        int[][] array3 = {{1, 2, 3},
                          {12,13,4},
                          {11,14,5},
                          {10,15,6},
                          {9, 8, 7}};

        System.out.println(spiralTraverse(array3));
    }
}
