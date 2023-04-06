import java.util.Arrays;

public class SubarraySort_Ex1 {
    public static int[] subarraySort(int[] array) {
        int N = array.length;
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for(int i = 0; i<N; i++){
            int num = array[i];
            if(isOutOfOrder(i,num,array)){
                minOutOfOrder = Math.min(minOutOfOrder, num);
                maxOutOfOrder = Math.max(maxOutOfOrder, num);
            }
        }
        if(minOutOfOrder == Integer.MAX_VALUE)  return new int[]{-1,-1};
        int leftIndex = 0, rightIndex = N-1;
        while (minOutOfOrder >= array[leftIndex])   leftIndex++;
        while (maxOutOfOrder <= array[rightIndex])  rightIndex--;

       return new int[]{leftIndex,rightIndex};
    }

    private static boolean isOutOfOrder(int i, int num, int[] array){
        if(i == 0)              return num > array[i+1];
        if(i == array.length-1) return num<array[i-1];
        return num > array[i+1] || num<array[i-1];
    }

    public static void main(String[] args) {
        int[] array ={1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] array2 = {3,1};
        System.out.println(Arrays.toString(subarraySort(array2)));
    }
}
