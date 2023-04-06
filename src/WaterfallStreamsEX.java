public class WaterfallStreamsEX {
    public static double[] waterfallStreams(double[][] array, int source){
        double[] rowAbove = array[0];
        rowAbove[source] = -1;

        for(int row = 1; row<array.length; row++){
            double[] currentRow = array[row];
            for(int i = 0; i<rowAbove.length; i++){
                double valueAbove = rowAbove[i];
                boolean hasWaterAbove = valueAbove<0;
                boolean hasBlock = currentRow[i]==1;
                
                if(!hasWaterAbove)  continue;
                if(!hasBlock){
                    currentRow[i] += valueAbove;
                    continue;
                }
                
                //to here currentRow[i] has block so splitWater
                double splitWater = valueAbove/2;
                int leftIdx = i;
                while (leftIdx-1 >= 0){
                    leftIdx -= 1;                   // 1,1,-1,0,0
                    if(rowAbove[leftIdx]==1) break; // 1,1, 1,1,1
                    if(currentRow[leftIdx] != 1){
                        currentRow[leftIdx] += splitWater;//下面有block就不会流下来了
                        break;
                    }
                }

                int rightIdx = i;
                while (rightIdx+1 < rowAbove.length){
                    rightIdx +=1;
                    if(rowAbove[rightIdx]==1) break;
                    if(currentRow[rightIdx] !=1){
                        currentRow[rightIdx] +=splitWater;
                        break;
                    }
                }
            }
            rowAbove = currentRow;
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
}
