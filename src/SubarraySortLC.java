public class SubarraySortLC {
    public static int findUnsortedSubarray(int[] array) {
        // Write your code here.
        int N = array.length;
        if(N==1) return 0;
        int minOutOrder = Integer.MAX_VALUE;
        int maxOutOrder = Integer.MIN_VALUE;

        for(int i = 0; i<N; i++){
            int num = array[i];
            if(isOutOfOrder(i,num,array)){
                minOutOrder = Math.min(minOutOrder,num);
                maxOutOrder = Math.max(maxOutOrder,num);
            }
        }
        if(maxOutOrder == Integer.MAX_VALUE)    return 0;
        int subarrayLeftIndex = 0;
        while (minOutOrder>=array[subarrayLeftIndex])   subarrayLeftIndex++;
        int subarrayRightIndex = N-1;
        while (maxOutOrder<=array[subarrayRightIndex])  subarrayRightIndex--;

        return subarrayRightIndex-subarrayLeftIndex+1;
    }

    private static boolean isOutOfOrder(int i, int num, int[] array){
        if(i == 0) return num > array[i+1];
        if(i == array.length-1) return num < array[i-1];
        return num > array[i+1] || num < array[i-1];
    }

    public static void main(String[] args) {
        int[] array = {1,2};
        System.out.println(findUnsortedSubarray(array));
    }
}
