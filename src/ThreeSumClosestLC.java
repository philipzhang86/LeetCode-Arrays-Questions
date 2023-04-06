import java.util.Arrays;

public class ThreeSumClosestLC {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int result = nums[0]+nums[1]+nums[N-1];
        for(int i = 0; i<N; i++){
            int lo = i+1;
            int hi = N-1;
            while (lo<hi){
                int sum = nums[i]+nums[lo]+nums[hi];
                if(Math.abs(target-sum)<Math.abs(target-result)){
                    result = sum;
                }else if(sum<target){
                    lo++;
                }else hi--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {-1,2,1,-4};
        System.out.println(threeSumClosest(array,1));
    }
}
