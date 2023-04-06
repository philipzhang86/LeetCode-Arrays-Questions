import java.util.Arrays;

public class WaterfallStreams {
    public static double[] waterfallStreams(double[][] array, int source) {
        // Write your code here.
        double[] rowAbove = array[0];
        //we'll use -1 to represent water, since 1 is used for a block.
        rowAbove[source] = -1;

        for(int row = 1; row<array.length; row++){
            double[] currentRow = array[row];
            for(int idx = 0; idx < rowAbove.length; idx++){// change rowAbove to currentRow maybe
                double valueAbove = rowAbove[idx];//for rowAbove
                boolean hasWaterAbove = valueAbove < 0; // for rowAbove
                boolean hasBlock = currentRow[idx] == 1; // for currentRow

                if(!hasWaterAbove) continue;//rowabove 没水 跳过

                if(!hasBlock){//当前rowAbove有水，再看看rowAbove下面有没有石头，没有的话把水一下来，continue 本轮循环
                    //if there is no block in the current column, move the water down.
                    currentRow[idx] += valueAbove;
                    continue;
                }

                double splitWater = valueAbove/2;

                //move water right
                int rightIdx = idx;
                while (rightIdx+1 < rowAbove.length){ // rowAbove == currentRow?
                    rightIdx+=1;
                    //啥情况？
                    if(rowAbove[rightIdx] == 1) break; // if there is a block in the way ?where is the block? above ? current?
                    if(currentRow[rightIdx] !=1){
                        currentRow[rightIdx] = splitWater + currentRow[rightIdx];
                        break;
                    }
                }

                //move water left;
                int leftIdx = idx;
                while (leftIdx -1 >= 0){
                    leftIdx -= 1;
                    if(rowAbove[leftIdx] == 1)  break;
                    if(currentRow[leftIdx] != 1){
                        currentRow[leftIdx] += splitWater;
                        break;
                    }
                }
            }
            rowAbove = currentRow;
        }
        for(int i =0; i<array.length; i++){
            System.out.println(Arrays.toString(array[i]));
        }

        double[] result = new double[rowAbove.length];
        for(int i = 0; i<rowAbove.length; i++){
            if(rowAbove[i]<0){
                result[i] = rowAbove[i] * -100;
            }
            else result[i]=rowAbove[i];
        }
        return result;
    }

    public static void main(String[] args) {
        double[][] array = {{0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0},
                            {0, 1, 1, 1, 1, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(waterfallStreams(array, 3)));
    }
}
