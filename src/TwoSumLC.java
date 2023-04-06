import java.util.Arrays;
import java.util.HashMap;

public class TwoSumLC {
    public static int[] twoSum(int[] nums, int target) {
       for(int i = 0; i<nums.length; i++){
           for(int j = i+1;j<nums.length;j++){
               if(nums[i]+nums[j]==target){
                   return new int[]{i,j};
               }
           }
       }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int residual = target-nums[i];
            if(map.containsKey(residual)){
                return new int[]{i,map.get(residual)};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
    }
}
