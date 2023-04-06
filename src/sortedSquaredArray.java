import java.util.Arrays;

public class sortedSquaredArray {
    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        Arrays.sort(array);
        for(int i = 0; i<array.length; i++){
            result[i] = array[i] * array[i];
        }
        return result;
    }
}
