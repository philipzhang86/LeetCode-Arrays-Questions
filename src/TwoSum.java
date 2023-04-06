import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public static int[] twoNumberSum(int[] array, int targetSum){

        for(int i = 0; i< array.length-1; i++){
            for(int j = i+1; j<array.length; j++){
                if(array[i]+array[j]==targetSum){
                    return new int[]{array[i], array[j]};
                }
            }
        }

        return new int[0];
    }

    public static int[] twoNumberSum_2 (int[] array, int targetSum){
        HashSet<Integer> set = new HashSet<>();
        for(int num : array){
            int residual = targetSum - num;
            if(set.contains(residual)){
                return new int[]{residual, num};
            }else {
                set.add(num);
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSum_3 (int[] array, int targetSum){
        Arrays.sort(array);
        int lo = 0, hi = array.length-1;
        while (lo<hi){
            int sum = array[lo] + array[hi];

            if(sum == targetSum){
                return new int[]{array[lo], array[hi]};
            }else if(sum<targetSum){
                lo++;
            }else hi--;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        System.out.println(Arrays.toString(twoNumberSum(array, 10)));
    }
}
