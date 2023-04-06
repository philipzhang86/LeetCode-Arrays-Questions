

public class MinSizeSubarraySum_LC {
    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= target) {
                result = Math.min(result, i - left + 1);


                sum -= nums[left++];

            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        int x = 13; //1101
        int y = 7;  //111
        //00000000 00000000 00000000 00001101       13 binary representation
        //00000000 00000000 00000000 00000111        7 binary representation
        //00000000 00000000 00000000 00000101        5 binary representation  & 计算结果

        System.out.println(x & y);//5
    }
}
