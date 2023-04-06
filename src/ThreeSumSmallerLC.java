import java.util.Arrays;

public class ThreeSumSmallerLC {

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int lo = i + 1;
            int hi = N - 1;
            while (lo < hi) {
                int residual = target - nums[i];
                if (nums[lo]+nums[hi]<residual) {
                    count +=hi-lo;//∵[lo ~ hi]<residual ∴ [lo~hi-1],[lo+1~hi]......区间所以情况也同样符合条件
                    lo++;
                }  else hi--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        System.out.println(threeSumSmaller(nums,2));
    }
}
/*
        for (int i = 0; i < N; i++) {
            int lo = i + 1;
            int hi = N - 1;
            while (lo < hi) {
                if (nums[i]+nums[lo]+nums[hi]<target) {
                    for(int j=hi; j>lo; j--){
                        List<Integer> sublist = Arrays.asList(nums[i], nums[lo], nums[j]);
                        list.add(sublist);
                    }
                    count +=hi-lo;
                    lo++;
                }  else hi--;
            }
        }
        System.out.println(list);
        return count;
*/