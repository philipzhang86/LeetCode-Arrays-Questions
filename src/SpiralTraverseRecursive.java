import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralTraverseRecursive {
    public static List<Integer> spiralTraverse(int[][] array){
        if(array.length==0) return new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();
        spiralTraverse(array,result,0, array.length-1,0,array[0].length-1 );
        return result;
    }

    private static void spiralTraverse(
            int[][] array,
            LinkedList<Integer> result,
            int startRow,
            int endRow,
            int startCol,
            int endCol){
        //记得写base case，如果唔是的话，会爆栈！！！！ 留意一下，正好和递推时的条件是相反的
        if(startRow > endRow || startCol > endCol) return;

        for(int col = startCol; col<=endCol; col++){
            result.add(array[startRow][col]);
        }

        for(int row = startRow+1; row<=endRow; row++){
            result.add(array[row][endCol]);
        }

        for(int col = endCol-1; col>=startCol; col--){
            if(startRow==endRow) break;
            result.add(array[endRow][col]);
        }

        for(int row = endRow -1; row>startRow; row--){
            if(startCol==endCol) break;
            result.add(array[row][startCol]);
        }
        //记得是+1、-1, 递归时argument++、--是会扑街的
        spiralTraverse(array,result, startRow+1,endRow-1,startCol+1,endCol-1);
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
