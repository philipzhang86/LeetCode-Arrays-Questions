import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        ArrayList<Integer[]> list = new ArrayList<>();
        int N = array.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int residual = targetSum - array[i] - array[j];
                int k = Arrays.binarySearch(array, residual);
                // find out the difference between array[k] exits or not
                if (k > j && array[k] == residual) {
                    list.add(new Integer[]{array[i], array[j], array[k]});
                }
            }
        }
        if (!list.isEmpty()) return list;
        return new ArrayList<Integer[]>();
    }

    public static List<Integer[]> threeNumberSumBi(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> list = new ArrayList<>();
        int N = array.length;
        for (int i = 0; i < N; i++) {
            if (i > 0 && array[i] == array[i - 1]) continue;
            int lo = i + 1;
            int hi = N - 1;
            while (lo < hi) {
                if (lo > i + 1 && array[lo] == array[lo + 1]) lo++;
                else if (array[i] + array[lo] + array[hi] == targetSum) {
                    list.add(new Integer[]{array[i], array[lo], array[hi]});
                    lo++;
                } else if (array[i] + array[lo] + array[hi] < targetSum) {
                    lo++;
                } else hi--;
            }
        }
        if (!list.isEmpty()) return list;
        return new ArrayList<Integer[]>();
    }

    public static void main(String[] args) {
        int[] array = {1, 1, -2};
        System.out.println(threeNumberSumBi(array, 0));
    }
}
