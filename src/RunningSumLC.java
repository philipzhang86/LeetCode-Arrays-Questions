public class RunningSumLC {
    public static int[] runningSum(int[] nums) {
        int temp = 0;
        for(int i = 0; i<nums.length; i++){
            temp+= nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {3,1,2,10,1};
        runningSum(array);
    }
}
