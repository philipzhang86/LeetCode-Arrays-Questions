import java.util.Arrays;

public class MissingNumLC {
    public static int missingNumber(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        for(int i = 0, j = 0; i<N; i++, j++){
            if(nums[i]!=j)  return j;
        }
        return N;
    }

    public static void main(String[] args) {
        int[] array = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(array));
    }
}
