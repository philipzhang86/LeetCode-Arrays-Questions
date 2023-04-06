import java.util.*;

public class SummaryRangeLC {
    // 解法参考了merge interval 的合并相同区间数组，但此法不是最优
    public static List<String> summaryRanges(int[] nums) {
        int N = nums.length;
        Deque<int[]> result = new LinkedList<>();
        if(N == 0) return new ArrayList<>();
        int[] current = new int[2];
        current[0] = nums[0];
        result.add(current);

        for(int i = 1; i<N; i++){
            int num = nums[i];
            if(num-1==nums[i-1]){
                current[1] = num;
            }else {
                int[] next = new int[2];
                next[0] = num;
                current = next;
                result.add(current);
            }
        }

        List<String> answer = new ArrayList<>();
        for(int[] interval : result){
            if(interval[1]!=0){
                answer.add(interval[0] +"->"+ interval[1]);//Integer.toString(interval[0])+"->"+Integer.toString(interval[1])
            }else answer.add(Integer.toString(interval[0]));
        }
        return  answer;
    }

    public static List<String> summaryRanges2(int[] nums){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            //上下两行代码有差别 i+1 < nums.length && start+1 == nums[i+1] 上面 [1->2][3->4][5->6] 有bug,不是真联动
            while (i+1 < nums.length && nums[i]+1 == nums[i+1]){//下面可以实现区间联动[1->5]
                i++;
            }
            if(start != nums[i]){
              result.add(start + "->" + nums[i]);
            }else{
                result.add(Integer.toString(start));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(summaryRanges(nums));
    }
}
