import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoSumLessKLC {
    public static int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
        int N = nums.length;
        int lo = 0;
        int hi = N-1;
        while (lo<hi){
            int sum = nums[lo]+nums[hi];
            if(sum<k){
                pq.add(sum);
                lo++;
            }else hi--;
        }
        if(!pq.isEmpty()) return pq.peek();
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {34,23,1,24,75,33,54,8};
        System.out.println(twoSumLessThanK(nums,60));
    }
}
