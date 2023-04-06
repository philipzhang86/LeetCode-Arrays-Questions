import java.util.Arrays;

public class DiagonalTraverseLC {
    public static int[] findDiagonalOrder(int[][] mat) {
        int height = mat.length-1;
        int width = mat[0].length-1;
        int[] result = new int[mat.length * mat[0].length];

        int row = 0;
        int col = 0;
        boolean goingUp = true;
        int index = 0;
        while (!isOutOfBounds(row,col,height,width)){
            result[index] = mat[row][col]; index++;
            if(goingUp){
                if(row == 0 || col == width){
                    goingUp = false;
                    if(col==width)  row++;//有可能括弧出错
                    else            col++;
                }else {
                    row--;
                    col++;
                }
            }else {
                if(col == 0 || row == height){
                    goingUp = true;
                    if(row == height)   col++;
                    else                row++;
                }else {
                    row++;
                    col--;
                }
            }
        }

        /*int[] result = new int[list.size()];
        for(int i = 0; i< result.length; i++){
            result[i] = list.get(i);
        }*/

        return result;
    }

    private static boolean isOutOfBounds(int row, int col, int height, int width){
        return row < 0 || row > height || col<0 || col > width;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }
}
