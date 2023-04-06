import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumLC {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i<N; i++){
            if(i > 0 && nums[i] == nums[i-1])   continue;
            for(int j = i+1; j<N; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int lo = j+1;
                int hi = N -1;
                while (lo < hi){
                    if(lo > j+1 && nums[lo] == nums[lo -1]) lo++;
                    else if(nums[i] + nums[j] + nums[lo] + nums[hi] == target){
                        List<Integer> sublist = Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]);
                        result.add(sublist);
                        lo++;
                    }else if(nums[i] + nums[j] + nums[lo] + nums[hi] < target){
                        lo++;
                    }else hi--;
                }
            }
        }

        if(!result.isEmpty())   return result;
        return new ArrayList<List<Integer>>();
    }

    public static void main(String[] args) {
        int[] array = {-3,-1,0,2,4,5};
        System.out.println(fourSum(array,2));
    }
}
