import java.util.Arrays;

public class SubarraySort {

    /*本题一直都在玩数，最后才将数转换为array的内容并返回
      1: 要明白哪怕array中出现一个out of order的元素，实现其正确位置的移动可能都是巨大的，所以直接搞array 不智
      2：移动一个错位元素，需要动两个元素，错位元素本身和因为错位元素移动而被迫跟着移动的相应元素
      3：找出最小、最大错位元素，将其与array[最左]、[最右]元素比较
      4：比较后得到的sorted正确indexes,就是本题答案
    * */
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for(int i = 0; i<array.length; i++){
            int num = array[i];
            if(isOutOfOrder(i, num, array)){//数组中一个错位元素的出现，意味着另一个在其正确位置的元素需要移动
               minOutOfOrder = Math.min(minOutOfOrder,num);//newMin replace oldMin
               maxOutOfOrder = Math.max(maxOutOfOrder,num);//通过大变小、小变大找出需要resort的区间
            }
        }
        if(minOutOfOrder == Integer.MAX_VALUE){// if array is sorted, return [-1,-1]
            return new int[]{-1,-1};
        }
        int subarrayLeftIdx = 0;
        //题目要求的是返回对应的subarray sort index
        while (minOutOfOrder >= array[subarrayLeftIdx]){
            subarrayLeftIdx++;//use the lowest cost to get the right subarray left index
        }

        int subarrayRightIdx = array.length-1;
        while (maxOutOfOrder<=array[subarrayRightIdx]){
            subarrayRightIdx--;
        }

        return new int[] {subarrayLeftIdx,subarrayRightIdx};
    }

    private static boolean isOutOfOrder(int i, int num, int[] array){
        if(i == 0)  return num > array[i+1];// index == 0, front > back failed!
        if(i == array.length-1) return num < array[i-1]; // index == last, last < last-1  failed!
        return num > array[i+1] || num < array[i - 1];// if front > back || back < front  failed!
    }

    public static void main(String[] args) {
        int[] array ={1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        System.out.println(Arrays.toString(subarraySort(array)));
    }
}
