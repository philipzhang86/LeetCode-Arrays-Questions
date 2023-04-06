import java.util.HashMap;
import java.util.Map;

public class LongestRangeLC {
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int count =1 ;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num, true);
        }
        for(int num : nums){
            if(!map.get(num)) continue;
            int currentLength = 1;
            int left = num -1;
            int right = num + 1;
            while (map.containsKey(left)){
                map.put(left,false);
                currentLength++;
                left--;
            }
            while (map.containsKey(right)){
                map.put(right, false);
                currentLength++;
                right++;
            }
            if(currentLength>count) count = currentLength;
        }
        return count;
    }



    public static void main(String[] args) {
        int[] array = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(array));
    }
}
