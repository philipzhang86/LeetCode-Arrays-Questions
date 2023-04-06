import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        int N = array.length;
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for(int i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                int lo = j+1;
                int hi = N-1;
                while (lo<hi){
                    if(array[i]+array[j]+array[lo]+array[hi] == targetSum){
                        result.add(new Integer[]{array[i], array[j], array[lo], array[hi]});
                        lo++;
                    }else if(array[i]+array[j]+array[lo]+array[hi] < targetSum) lo++;
                    else hi--;
                }
            }
        }

        if(!result.isEmpty())   return result;
        return new ArrayList<Integer[]>();
    }

    public static void main(String[] args) {
        int[] array = {7, 6, 4, -1, 1, 2};
        System.out.println(fourNumberSum(array, 16));
    }
}
