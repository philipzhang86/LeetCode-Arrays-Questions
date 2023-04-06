import java.util.ArrayList;
import java.util.List;

// Could the candidate transcribe simple logic to code? test your iterative or recursive skills
// 是否有足够细心、逻辑去解决边界定义的问题；玩指针：4 指针
public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        int N = array.length;
        if(N == 0)  return new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<>();

        int startRow = 0;
        int endRow = N-1;
        int startCol = 0;
        int endCol = array[0].length-1;

        //边界一定要搞清楚
        while (startRow<=endRow && startCol <= endCol){
            for(int col = startCol; col<= endCol; col++){
                list.add(array[startRow][col]);
            }

            for(int row = startRow+1; row<=endRow; row++){
                list.add(array[row][endCol]);
            }

            for(int col = endCol-1; col>=startCol; col--){
                if(startRow == endRow) break; // handle edge cases
                list.add(array[endRow][col]);
            }

            for(int row = endRow-1; row>startRow; row--){
                if(startCol==endCol) break;  // handle edge cases
                list.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4},
                {12,13,14,5},
                {11,16,15,6},
                {10, 9, 8,7}};
        System.out.println(spiralTraverse(array));
    }

}
