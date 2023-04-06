public class RobHouseLC {
    public static int rob(int[] nums) {
        int N = nums.length;
        if(N == 0) return 0;
        if(N == 1) return nums[0];

        int[] mark = new int[N];
        mark[0] = nums[0];
        mark[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i<N; i++){
            int o = nums[i]+mark[i-2];
            int k = mark[i-1];
            mark[i] = Math.max(nums[i]+mark[i-2], mark[i-1]);
        }
        return mark[N-1];
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,1};
        System.out.println(rob(array));
    }
}
