import java.util.Arrays;
import java.util.HashSet;

public class FirstDuplicateValue {
    public static int firstDuplicateValue(int[] array) {
        // Write your code here.
        HashSet<Integer> set = new HashSet<>();
        for (int j : array) {
            if (set.contains(j)) return j;
            set.add(j);
        }
        return -1;
    }

    public static void twoDArraySort(int[][] array){
        Arrays.sort(array,(a, b)-> Integer.compare(a[0],b[0]));
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 5, 3, 3, 2, 4};
        System.out.println(firstDuplicateValue(array));
    }
}
