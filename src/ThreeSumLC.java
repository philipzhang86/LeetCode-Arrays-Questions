import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumLC {
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sublist = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (!list.contains(sublist)) list.add(sublist);
                    }
                }
            }
        }
        if (!list.isEmpty()) return list;
        return new ArrayList<List<Integer>>();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1;
            int hi = N - 1;
            while (lo < hi) {
                if (lo > i + 1 && nums[lo] == nums[lo - 1]) {
                    lo++;
                } else if (nums[i] + nums[lo] + nums[hi] == 0) {
                    List<Integer> sublist = Arrays.asList(nums[i], nums[lo], nums[hi]);
                    list.add(sublist);
                    lo++;
                } else if (nums[i] + nums[lo] + nums[hi] < 0) {
                    lo++;
                } else hi--;
            }
        }
        if (!list.isEmpty()) return list;
        return new ArrayList<List<Integer>>();
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
